import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.platform.win32.WinNT.HANDLE;

import java.io.IOException;
import java.util.HashMap;

public class IRSDKAccess {
    private static IRSDKAccess INSTANCE;
    public static IRSDKAccess getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new IRSDKAccess();
        }
        return INSTANCE;
    }

    protected HANDLE memMappedFile;
    protected Pointer buf;
    protected HANDLE newDataEvent;
    public boolean isConnected() {
        return memMappedFile != null && buf != null && newDataEvent != null;
    }
    public boolean isSimRunning() {
        return (irsdkHeader.getStatus() & 1) != 0;
    }

    protected IRSDKHeader irsdkHeader;
    public HashMap<String, IRSDKVarHeader> cachedVarHeaders = new HashMap<>();

    protected Pointer varBufSnapshot;
    protected int lastSuccessSnapshotTickCount = Integer.MAX_VALUE;

    public void openConnection() throws IOException {
        final String IRSDKMemMapFileName = "Local\\IRSDKMemMapFileName";
        final String IRSDKDataValidEvent = "Local\\IRSDKDataValidEvent";

        memMappedFile = Kernel32.INSTANCE.OpenFileMapping(WinNT.FILE_MAP_READ, false, IRSDKMemMapFileName);
        if (memMappedFile == null) {
            throw new IllegalStateException("Failed to open telemetry file.");
        }

        buf = Kernel32.INSTANCE.MapViewOfFile(memMappedFile, WinBase.FILE_MAP_READ, 0, 0, 0);
        if (buf == null) {
            throw new IllegalStateException("Unable to load telemetry file into memory.");
        }
        irsdkHeader = new IRSDKHeader(buf);

        newDataEvent = Kernel32.INSTANCE.OpenEvent(WinNT.SYNCHRONIZE, false, IRSDKDataValidEvent);
        if (newDataEvent == null) {
            throw new IllegalStateException("Unable to subscribe to new data event.");
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

    public boolean waitForNewData() throws IllegalStateException {
        if (!isConnected()) {
            throw new IllegalStateException("Yet to connect to iRacing telemetry data. Have you called openConnection() first?");
        } else if (!isSimRunning()) {
            throw new IllegalStateException("iRacing not running.");
        }

        if (!getNewData()) {
            Kernel32.INSTANCE.WaitForSingleObject(newDataEvent, irsdkHeader.getCurBufTickCount());
            return getNewData();
        }
        return true;
    }

    public IRSDKVarHeader getVarHeaderByName(String name) throws IllegalArgumentException {
        if (cachedVarHeaders.containsKey(name)) {
            return cachedVarHeaders.get(name);
        }
        for(int idx = 0; idx < irsdkHeader.getNumVars(); ++idx) {
            IRSDKVarHeader varHeader = new IRSDKVarHeader(buf, irsdkHeader.calcIdxVarHeaderOffset(idx));
            if (varHeader.getName().equals(name)) {
                return varHeader;
            }
        }
        throw new IllegalArgumentException("Variable %s not found".formatted(name));
    }

    public boolean[] getBooleanArray(IRSDKVarHeader forHeader) {
        int count = forHeader.getCount();
        byte[] temp = varBufSnapshot.getByteArray(forHeader.getOffset(), count);
        boolean[] res = new boolean[count];
        for(int i = 0; i < count; i++) {
            res[i] = temp[i] == 1;
        }
        return res;
    }
    public boolean getBoolean(IRSDKVarHeader forHeader) {
        return varBufSnapshot.getByte(forHeader.getOffset()) == 1;
    }
    public byte[] getByteArray(IRSDKVarHeader forHeader) {
        int count = forHeader.getCount();
        return varBufSnapshot.getByteArray(forHeader.getOffset(), count);
    }
    public byte getByte(IRSDKVarHeader forHeader) {
        return varBufSnapshot.getByte(forHeader.getOffset());
    }
    public char[] getCharArray(IRSDKVarHeader forHeader) {
        int count = forHeader.getCount();
        byte[] temp = varBufSnapshot.getByteArray(forHeader.getOffset(), count);
        char[] res = new char[count];
        for(int i = 0; i < count; i++) {
            res[i] = (char)temp[i];
        }
        return res;
    }
    public char getChar(IRSDKVarHeader forHeader) {
        return (char)varBufSnapshot.getByte(forHeader.getOffset());
    }
    public int[] getIntArray(IRSDKVarHeader forHeader) {
        int count = forHeader.getCount();
        return varBufSnapshot.getIntArray(forHeader.getOffset(), count);
    }
    public int getInt(IRSDKVarHeader forHeader) {
        return varBufSnapshot.getInt(forHeader.getOffset());
    }
    public float[] getFloatArray(IRSDKVarHeader forHeader) {
        int count = forHeader.getCount();
        return varBufSnapshot.getFloatArray(forHeader.getOffset(), count);
    }
    public float getFloat(IRSDKVarHeader forHeader) {
        return varBufSnapshot.getFloat(forHeader.getOffset());
    }
    public double[] getDoubleArray(IRSDKVarHeader forHeader) {
        int count = forHeader.getCount();
        return varBufSnapshot.getDoubleArray(forHeader.getOffset(), count);
    }
    public double getDouble(IRSDKVarHeader forHeader) {
        return varBufSnapshot.getDouble(forHeader.getOffset());
    }
}
