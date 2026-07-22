import com.sun.jna.Pointer;

import java.nio.charset.StandardCharsets;

public class IRSDKVarHeader {
    private final int headerOffset;
    private final Pointer sharedMem;

    public IRSDKDefines.IRSDKVarType getType(){
        return IRSDKDefines.IRSDKVarType.values()[sharedMem.getInt(headerOffset)];
    } // IRSDKDefines.IRSDKVarType
    public int getOffset() {
        return sharedMem.getInt(headerOffset + 4);
    } // offset fron start of buffer row
    public int getCount() {
        return sharedMem.getInt(headerOffset + 8);
    } // number of entries (array)
    // so length in bytes would be irsdk_VarTypeBytes[type] * count

    public boolean getCountAsTime() {
        return sharedMem.getByte(headerOffset + 12) == 1;
    }

    public String getName() {
        int offset = headerOffset + 16;
        return sharedMem.getString(offset);
    }
    public String getDesc() {
        int offset = headerOffset + 16 + IRSDKDefines.IRSDK_MAX_STRING;
        return sharedMem.getString(offset);
    }
    public String getUnit() {
        int offset = headerOffset + 16 + IRSDKDefines.IRSDK_MAX_STRING + IRSDKDefines.IRSDK_MAX_DESC;
        return sharedMem.getString(offset);
    }

    public IRSDKVarHeader(Pointer buf, int offset) {
        sharedMem = buf;
        headerOffset = offset;
    }
}
