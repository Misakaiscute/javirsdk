package javirsdk;

import javirsdk.broadcast.JavirsdkBroadcastMsg;
import javirsdk.exceptions.JavirsdkIRacingClosingException;
import javirsdk.exceptions.JavirsdkIRacingNotRunningException;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.*;
import com.sun.jna.platform.win32.WinNT.HANDLE;
import irsdkdef.IRSDKHeader;
import irsdkdef.IRSDKVarBuf;
import irsdkdef.IRSDKVarHeader;
import javirsdk.handler.JavirsdkHandlerExecutor;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.function.Consumer;

/**
 * Javirsdk is the singleton main entrypoint for the javirsdk package
 *
 * Main interfaces for most users are:
 *    '.connect',
 *    '.disconnect',
 *    and handler binding with '.handlerExecutor'.
 */
public final class Javirsdk {
    //Singleton
    private static Javirsdk INSTANCE;
    public static Javirsdk getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Javirsdk();
        }
        return INSTANCE;
    }
    //Handler management
    /**
     * Allows binds tasks to run for each time iRacing signals new data available
     * in its buffer.
     *
     * Starts automatically using RunHelper, needs to be started manually otherwise.
     */
    public final JavirsdkHandlerExecutor handlerExecutor = new JavirsdkHandlerExecutor();
    //Run helper
    public static final class RunHelper {
        private final Runnable whileDisconnected;
        private final Runnable whileIdling;
        private final Consumer<IOException> onConnectionErr; 
        private final int connectionRetryIntervalMs;

        private RunHelper(Runnable whileDisconnected, Runnable whileIdling, Consumer<IOException> onConnectionErr, int connectionRetryIntervalMs) {
            this.whileDisconnected = whileDisconnected;
            this.whileIdling = whileIdling;
            this.onConnectionErr = onConnectionErr;
            this.connectionRetryIntervalMs = connectionRetryIntervalMs;
        }
        public static final class Builder {
            private Runnable hWhileDisconnected = () -> {};
            public Builder setWhileDisconnected(Runnable hWhileDisconnected) {
                this.hWhileDisconnected = hWhileDisconnected;
                return this;
            }

            private Runnable hWhileIdling = () -> {};
            public Builder setWhileIdling(Runnable hWhileIdling) {
                this.hWhileIdling = hWhileIdling;
                return this;
            }

            private Consumer<IOException> hOnConnectionErr = (IOException e) -> {};
            public Builder setOnConnectionErr(Consumer<IOException> hOnConnectionErr) {
                this.hOnConnectionErr = hOnConnectionErr;
                return this;
            }

            private int hConnectionRetryIntervalMs = 1000;
            public Builder setConnectionRetryIntervalMs(int hConnectionRetryIntervalMs) {
                this.hConnectionRetryIntervalMs = hConnectionRetryIntervalMs;
                return this;
            }
   
            public RunHelper build() {
                return new RunHelper(hWhileDisconnected, hWhileIdling, hOnConnectionErr, hConnectionRetryIntervalMs);
            } 
        }
        public void run() {
            Javirsdk sdk = Javirsdk.getInstance();
            while (true) {
                if (sdk.isConnected()) {
                    if (!sdk.isSimRunning()) {
                        whileIdling.run();
                    }
                } else {
                    whileDisconnected.run();
                    try {
                        sdk.connect();
                        //If there are waiting handlers, start running them
                        if (sdk.handlerExecutor.hasHandlers()) {
                            sdk.handlerExecutor.start();
                        }
                    } catch (IOException e) {
                        onConnectionErr.accept(e);
                    } catch (JavirsdkIRacingNotRunningException e) {} finally {
                        try {
                            Thread.sleep(connectionRetryIntervalMs);
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                }
            }
        }
    }

    //Exception handling
    private Runnable actionOnException = () -> {};
    /**
     * Set the lambda to run before closing the connection 
     * with 'onIRacingClosing'
     * @param a Accepts a lambda expression or null (which is equal to an empty lambda)
     */
    public void setOnIRacingClosingAction(Runnable a) {
        if (a == null) {
            actionOnException = () -> {};
        }
        actionOnException = a;
    }
    /**
     * Closes the connection to the sdk and runs the action
     * specified with 'setOnIRacingClosingAction'
     */
    public void onIRacingClosing() {
        actionOnException.run();
        disconnect();
    }

    //Opening of required channels
    private HANDLE memMappedFile;
    private Pointer buf;
    private HANDLE newDataEvent;
    private int broadcastMsgId = -1;
    private IRSDKHeader irsdkHeader;
    /**
     * @return if the connection is open to the shared memory region of iRacing,
     * returns true
     */
    public boolean isConnected() {
        return memMappedFile != null && buf != null && newDataEvent != null;
    }
    /**
     * @return if the connection is open to the shared memory region,
     * returns true if the iRacing simulator is running
     */
    public boolean isSimRunning() {
        return isConnected() && (irsdkHeader.getStatus() & 1) != 0;
    }

    public void connect() throws IOException {
        final String IRSDKMemMapFileName = "Local\\IRSDKMemMapFileName";
        final String IRSDKDataValidEvent = "Local\\IRSDKDataValidEvent";
        final String IRSDKBroadcastMsgName = "IRSDK_BROADCASTMSG";

        memMappedFile = Kernel32.INSTANCE.OpenFileMapping(WinNT.FILE_MAP_READ, false, IRSDKMemMapFileName);
        if (memMappedFile == null) {
            throw new IOException("Failed to open telemetry file.");
        }
        buf = Kernel32.INSTANCE.MapViewOfFile(memMappedFile, WinBase.FILE_MAP_READ, 0, 0, 0);
        if (buf == null) {
            throw new IOException("Unable to load telemetry file into memory.");
        }
        newDataEvent = Kernel32.INSTANCE.OpenEvent(WinNT.SYNCHRONIZE, false, IRSDKDataValidEvent);
        if (newDataEvent == null) {
            throw new IOException("Unable to subscribe to new data event.");
        }
        broadcastMsgId = User32.INSTANCE.RegisterWindowMessage(IRSDKBroadcastMsgName);
        if (broadcastMsgId == 0) {
            throw new IOException("Unable to open message channel.");
        }
        //These will not throw an exception, when any other app (f.e. Trading Paints or Garage61)
        //keeps the memory mapped file open.
        //Fallback:
        irsdkHeader = new IRSDKHeader(buf);
        if (irsdkHeader.getBufLen() <= 0) {
            disconnect();
            throw new IOException("SDK buffer empty.");
        } else if ((irsdkHeader.getStatus() & 1) == 0) {
            throw new IOException("SDK available, iRacing not running.");
        }
        varBufSnapshot = new Memory(irsdkHeader.getBufLen());

        
    }
    public void disconnect() {
        if (Kernel32.INSTANCE.CloseHandle(newDataEvent)) {
            newDataEvent = null;
        }
        if (Kernel32.INSTANCE.UnmapViewOfFile(buf)) {
            buf = null;
        }
        if (Kernel32.INSTANCE.CloseHandle(memMappedFile)) {;
            memMappedFile = null;
        }
        irsdkHeader = null;
        broadcastMsgId = -1;

        lastSuccessSnapshotTickCount = Integer.MAX_VALUE;
        varBufSnapshot = null;
        cachedVarHeaders.clear();
    }

    //Message broadcasting
    public void broadcastMsg(JavirsdkBroadcastMsg msg) throws JavirsdkIRacingNotRunningException {
        if (!isSimRunning()) {
            throw new JavirsdkIRacingNotRunningException("iRacing not running.");
        } else if (broadcastMsgId == -1) {
            throw new JavirsdkIRacingNotRunningException("Broadcasting channel isn't open.");
        }

        User32.INSTANCE.PostMessage(User32.HWND_BROADCAST, broadcastMsgId, msg.getFirstParam(), msg.getSecondParam());
    }

    //New data retrieval
    private Pointer varBufSnapshot;
    private int lastSuccessSnapshotTickCount = Integer.MAX_VALUE;
    public boolean getNewData() throws JavirsdkIRacingNotRunningException {
        if (!isSimRunning()) {
            throw new JavirsdkIRacingNotRunningException("iRacing not running.");
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
    public void waitForNewData() throws JavirsdkIRacingNotRunningException, JavirsdkIRacingClosingException {
        try { //We might get an IRacingNotRunning exception anywhere here
            if (!getNewData()) {
                Kernel32.INSTANCE.WaitForSingleObject(newDataEvent, irsdkHeader.getCurBufTickCount());
                getNewData();
            }    
        } catch (JavirsdkIRacingNotRunningException e) {
            if (lastSuccessSnapshotTickCount == Integer.MAX_VALUE) { //If the tickCount didn't change since initialization, iRacing never ran
                throw e;
            } else { //If it has, then iRacing must have closed
                throw new JavirsdkIRacingClosingException("iRacing just closed...");
            }
        }
    }

    //Variable retrival
    private final HashMap<String, IRSDKVarHeader> cachedVarHeaders = new HashMap<>();
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
    public IRSDKVarHeader[] scoutVarHeaderNames() {
        LinkedList<IRSDKVarHeader> varHeaders = new LinkedList<>();
        for(int i = 0; i < irsdkHeader.getNumVars(); ++i) {
            IRSDKVarHeader varHeader = new IRSDKVarHeader(buf, varBufSnapshot, irsdkHeader.calcIdxVarHeaderOffset(i));
            varHeaders.add(varHeader);
        }
        return varHeaders.toArray(IRSDKVarHeader[]::new);
    }
}
