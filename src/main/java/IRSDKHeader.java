import com.sun.jna.Pointer;

public class IRSDKHeader {
    private final Pointer buf;
    public static final int IRSDK_MAX_BUFS = 4;

    public int getVersion() {
        return buf.getInt(0);
    } // this api header version, see IRSDK_VER
    public int getStatus() {
        return buf.getInt(4);
    } // bitfield using irsdk_StatusField
    public int getTickRateMs() {
        return (int)Math.ceil((double)1000 / buf.getInt(8));
    } // time between writes (ms)

    // Session information, updated periodically
    public int getSessionInfoUpdate() {
        return buf.getInt(12);
    } // Incremented when session info changes
    public int getSessionInfoLen() {
        return buf.getInt(16);
    } // Length in bytes of session info string
    public int sessionInfoOffset() {
        return buf.getInt(20);
    } // Session info, encoded in YAML format

    // State data, output at tickRate
    public int getNumVars() {
        return buf.getInt(24);
    } // length of array pointed to by varHeaderOffset
    public int getVarHeaderOffset() {
        return buf.getInt(28);
    } // offset to irsdk_varHeader[numVars] array, Describes the variables received in varBuf

    public int getNumBuf() {
        return buf.getInt(32);
    } // <= IRSDK_MAX_BUFS (3 for now)
    public int getBufLen() {
        return buf.getInt(36);
    } // length in bytes for one line
    public int getCurBufTickCount() {
        return buf.getInt(40);
    } // stashed copy of the current tickCount, can read this to see if new data is available
    public byte getCurBuf() {
        return buf.getByte(44);
    } // index of the most recently written buffer (0 to IRSDK_MAX_BUFS-1) NOTE: this is an UNSIGNED char in the official SDK
    public IRSDKVarBuf getVarBuf(int index) throws IllegalArgumentException {
        if (index < 0 || index >= getNumBuf()) {
            throw new IllegalArgumentException(String.format("Index must be 0<index<IRSDK_MAX_BUF, : %d", index));
        }
        return new IRSDKVarBuf(buf, 48 + index * getBufLen());
    }

    public IRSDKHeader(Pointer buf) {
        this.buf = buf;
    }

    public int calcIdxVarHeaderOffset(int idx) {
        return getVarHeaderOffset() + idx * IRSDKVarHeader.SIZE_BYTE;
    }
}