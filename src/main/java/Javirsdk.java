import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import irsdkdef.IRSDKHeader;
import irsdkdef.IRSDKVarBuf;
import irsdkdef.IRSDKVarHeader;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public final class Javirsdk {
    private static Javirsdk INSTANCE;
    public static Javirsdk getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Javirsdk();
        }
        return INSTANCE;
    }
    private Javirsdk() {
        handlerExecutor.setDaemon(true);
    }

    private final ConcurrentHashMap<String, JavirsdkNewDataHandler> handlers = new ConcurrentHashMap<>(16);
    private final JavirsdkNewIrsdkDataRunner runner = new JavirsdkNewIrsdkDataRunner(handlers);
    private final Thread handlerExecutor = new Thread(runner);

    private HANDLE memMappedFile;
    private Pointer buf;
    private HANDLE newDataEvent;
    private IRSDKHeader irsdkHeader;
    public boolean isConnected() {
        return memMappedFile != null && buf != null && newDataEvent != null;
    }
    public boolean isSimRunning() {
        return isConnected() && (irsdkHeader.getStatus() & 1) != 0;
    }

    private final HashMap<String, IRSDKVarHeader> cachedVarHeaders = new HashMap<>();

    private Pointer varBufSnapshot;
    private int lastSuccessSnapshotTickCount = Integer.MAX_VALUE;

    public void openConnection() throws IOException {
        final String IRSDKMemMapFileName = "Local\\IRSDKMemMapFileName";
        final String IRSDKDataValidEvent = "Local\\IRSDKDataValidEvent";

        memMappedFile = Kernel32.INSTANCE.OpenFileMapping(WinNT.FILE_MAP_READ, false, IRSDKMemMapFileName);
        if (memMappedFile == null) {
            throw new IOException("Failed to open telemetry file.");
        }

        buf = Kernel32.INSTANCE.MapViewOfFile(memMappedFile, WinBase.FILE_MAP_READ, 0, 0, 0);
        if (buf == null) {
            throw new IOException("Unable to load telemetry file into memory.");
        }
        irsdkHeader = new IRSDKHeader(buf);

        newDataEvent = Kernel32.INSTANCE.OpenEvent(WinNT.SYNCHRONIZE, false, IRSDKDataValidEvent);
        if (newDataEvent == null) {
            throw new IOException("Unable to subscribe to new data event.");
        }

        //If everything went well and there are waiting handlers, start running them
        if (!handlers.isEmpty()) {
            handlerExecutor.start();
        }
    }
    public void closeConnection() {
        if (newDataEvent != null) {
            Kernel32.INSTANCE.CloseHandle(newDataEvent);
            newDataEvent = null;
        }
        if (buf != null) {
            Kernel32.INSTANCE.UnmapViewOfFile(buf);
            buf = null;
        }
        if (memMappedFile != null) {
            Kernel32.INSTANCE.CloseHandle(memMappedFile);
            memMappedFile = null;
        }

        lastSuccessSnapshotTickCount = Integer.MAX_VALUE;
        irsdkHeader = null;
        varBufSnapshot = null;
        cachedVarHeaders.clear();
    }

    public boolean getNewData() throws IllegalStateException {
        if (!isConnected()) {
            throw new IllegalStateException("Yet to connect to iRacing telemetry data. Have you called openConnection() first?");
        } else if (!isSimRunning()) {
            throw new IllegalStateException("iRacing not running.");
        }

        if (lastSuccessSnapshotTickCount == irsdkHeader.getCurBufTickCount()) {
            return false;
        }

        IRSDKVarBuf latestWrittenBuf = irsdkHeader.getVarBuf(irsdkHeader.getCurBuf());
        if (lastSuccessSnapshotTickCount < latestWrittenBuf.postWriteTickCount) {
            for(int count = 0; count < 2; ++count) {
                int curTickCount = latestWrittenBuf.postWriteTickCount;

                byte[] temp = new byte[irsdkHeader.getBufLen()];
                buf.read(latestWrittenBuf.varsOffsetFromHeader, temp, 0, irsdkHeader.getBufLen());
                varBufSnapshot.write(0, temp, 0, temp.length);

                if (curTickCount == latestWrittenBuf.preWriteTickCount) {
                    lastSuccessSnapshotTickCount = curTickCount;
                    return true;
                }
            }
        } else if (lastSuccessSnapshotTickCount > latestWrittenBuf.postWriteTickCount) {
            lastSuccessSnapshotTickCount = latestWrittenBuf.postWriteTickCount;
            return false;
        }

        return false;
    }
    public void waitForNewData() throws IllegalStateException {
        if (!isConnected()) {
            throw new IllegalStateException("Yet to connect to iRacing telemetry data. Have you called openConnection() first?");
        } else if (!isSimRunning()) {
            throw new IllegalStateException("iRacing not running.");
        }

        if (!getNewData()) {
            Kernel32.INSTANCE.WaitForSingleObject(newDataEvent, irsdkHeader.getCurBufTickCount());
            getNewData();
        }
    }

    public IRSDKVarHeader getVarHeaderByName(String name) throws IllegalArgumentException {
        if (cachedVarHeaders.containsKey(name)) {
            return cachedVarHeaders.get(name);
        }
        for(int idx = 0; idx < irsdkHeader.getNumVars(); ++idx) {
            IRSDKVarHeader varHeader = new IRSDKVarHeader(buf, varBufSnapshot, irsdkHeader.calcIdxVarHeaderOffset(idx));
            if (varHeader.getName().equals(name)) {
                return varHeader;
            }
        }
        throw new IllegalArgumentException("Variable %s not found".formatted(name));
    }

    public void bindNewIrsdkDataHandler(String id, JavirsdkNewDataHandler handler) {
        handlers.put(id, handler);
        if (!handlerExecutor.isAlive() && isSimRunning()) {
            handlerExecutor.start();
        }
    }
    public void unbindNewIrsdkDataHandler(String id) {
        handlers.remove(id);
        //No need to stop the executor, once all the handlers are removed, it'll return
    }
}
