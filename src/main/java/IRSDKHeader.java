import com.sun.jna.Pointer;

public class IRSDKHeader {
    private Pointer sharedMem;

    public int getVersion() {
        return sharedMem.getInt(0);
    } // this api header version, see IRSDK_VER
    public int getStatus() {
        return sharedMem.getInt(4);
    } // bitfield using irsdk_StatusField
    public int getTickRate() {
        return sharedMem.getInt(8);
    } // ticks per second (60 or 360 etc.)

    // Session information, updated periodically
    public int getSessionInfoUpdate() {
        return sharedMem.getInt(12);
    } // Incremented when session info changes
    public int getSessionInfoLen() {
        return sharedMem.getInt(16);
    } // Length in bytes of session info string
    public int sessionInfoOffset() {
        return sharedMem.getInt(20);
    } // Session info, encoded in YAML format

    // State data, output at tickRate
    public int getNumVars() {
        return sharedMem.getInt(24);
    } // length of array pointed to by varHeaderOffset
    public int getVarHeaderOffset() {
        return sharedMem.getInt(28);
    } // offset to irsdk_varHeader[numVars] array, Describes the variables received in varBuf

    public int getNumBuf() {
        return sharedMem.getInt(32);
    } // <= IRSDK_MAX_BUFS (3 for now)
    public int getBufLen() {
        return sharedMem.getInt(36);
    } // length in bytes for one line
    public int getCurBufTickCount() {
        return sharedMem.getInt(40);
    } // stashed copy of the current tickCount, can read this to see if new data is available
    public byte getCurBuf() {
        return sharedMem.getByte(44);
    } // index of the most recently written buffer (0 to IRSDK_MAX_BUFS-1) NOTE: this is an UNSIGNED char in the official SDK
    public IRSDKVarBuf[] varBuf = new IRSDKVarBuf[IRSDKDefines.IRSDK_MAX_BUFS]; // buffers of data being written to

    private IRSDKHeader() {}
    private static IRSDKHeader INSTANCE;
    public static IRSDKHeader getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new IRSDKHeader();
        }
        return INSTANCE;
    }

    public static void update(Pointer buf) {
        IRSDKHeader h = IRSDKHeader.getInstance();
        h.sharedMem = buf;

        for(int i = 0; i < IRSDKDefines.IRSDK_MAX_BUFS; ++i) {
            h.varBuf[i] = new IRSDKVarBuf(buf, 48 + i * 16);
        }
    }

    public IRSDKVarHeader getVarHeaderEntry(int idx) {
        return new IRSDKVarHeader(sharedMem, calcIdxVarHeaderOffset(idx));
    }

    public int scoutNameToIdx(String name) throws IllegalArgumentException {
        for(int idx = 0; idx < getNumVars(); ++idx) {
            IRSDKVarHeader varHeader = new IRSDKVarHeader(sharedMem, calcIdxVarHeaderOffset(idx));
            if (varHeader.getName().equals(name)) {
                return idx;
            }
        }
        throw new IllegalArgumentException("Variable %s not found".formatted(name));
    }

    private int calcIdxVarHeaderOffset(int idx) {
        return getVarHeaderOffset() + idx * IRSDKDefines.VAR_HEADER_SIZE_BYTE;
    }
}