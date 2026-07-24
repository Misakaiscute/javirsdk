import com.sun.jna.Pointer;

public class IRSDKVarHeader {
    public enum IRSDKVarType {
        IRSDK_CHAR,
        IRSDK_BOOL,
        IRSDK_INT,
        IRSDK_BITFIELD,
        IRSDK_FLOAT,
        IRSDK_DOUBLE
    }

    public static final int SIZE_BYTE = 144;
    private final int IRSDK_MAX_STRING = 32;
    private final int IRSDK_MAX_DESC = 64;

    private final int headerOffset;
    private final Pointer sharedBuf;

    public IRSDKVarType getType(){
        return IRSDKVarType.values()[sharedBuf.getInt(headerOffset)];
    } // IRSDKDefines.IRSDKVarType
    public int getOffset() {
        return sharedBuf.getInt(headerOffset + 4);
    } // offset fron start of buffer row
    public int getCount() {
        return sharedBuf.getInt(headerOffset + 8);
    } // number of entries (array)
    // so length in bytes would be irsdk_VarTypeBytes[type] * count

    public boolean getCountAsTime() {
        return sharedBuf.getByte(headerOffset + 12) == 1;
    }

    public String getName() {
        int offset = headerOffset + 16;
        return sharedBuf.getString(offset);
    }
    public String getDesc() {
        int offset = headerOffset + 16 + IRSDK_MAX_STRING;
        return sharedBuf.getString(offset);
    }
    public String getUnit() {
        int offset = headerOffset + 16 + IRSDK_MAX_STRING + IRSDK_MAX_DESC;
        return sharedBuf.getString(offset);
    }

    public IRSDKVarHeader(Pointer sharedBuf, int offset) {
        this.sharedBuf = sharedBuf;
        headerOffset = offset;
    }
}
