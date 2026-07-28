package irsdkdef;

import com.sun.jna.Pointer;

public final class IRSDKVarHeader {
    public static final int SIZE_BYTE = 144;
    private final int IRSDK_MAX_STRING = 32;
    private final int IRSDK_MAX_DESC = 64;

    private final Pointer sharedBuf;
    private final Pointer varBufSnapshot;
    private final int sharedBufOffset;

    public IRSDKVarType getType(){
        return IRSDKVarType.values()[sharedBuf.getInt(sharedBufOffset)];
    } // IRSDKDefines.irsdkdef.IRSDKVarType
    public int getVarBufOffset() {
        return sharedBuf.getInt(sharedBufOffset + 4);
    } // offset fron start of buffer row
    public int getCount() {
        return sharedBuf.getInt(sharedBufOffset + 8);
    } // number of entries (array)
    // so length in bytes would be irsdk_VarTypeBytes[type] * count

    public boolean getCountAsTime() {
        return sharedBuf.getByte(sharedBufOffset + 12) == 1;
    }

    public String getName() {
        int offset = sharedBufOffset + 16;
        return sharedBuf.getString(offset);
    }
    public String getDesc() {
        int offset = sharedBufOffset + 16 + IRSDK_MAX_STRING;
        return sharedBuf.getString(offset);
    }
    public String getUnit() {
        int offset = sharedBufOffset + 16 + IRSDK_MAX_STRING + IRSDK_MAX_DESC;
        return sharedBuf.getString(offset);
    }

    public IRSDKVarHeader(Pointer sharedBuf, Pointer varBufSnapshot, int sharedBufOffset) {
        this.sharedBuf = sharedBuf;
        this.varBufSnapshot = varBufSnapshot;
        this.sharedBufOffset = sharedBufOffset;
    }

    public boolean[] getBooleanArray() {
        int count = getCount();
        byte[] temp = varBufSnapshot.getByteArray(getVarBufOffset(), count);
        boolean[] res = new boolean[count];
        for(int i = 0; i < count; i++) {
            res[i] = temp[i] == 1;
        }
        return res;
    }
    public boolean getBoolean() {
        return varBufSnapshot.getByte(getVarBufOffset()) == 1;
    }
    public byte[] getByteArray() {
        int count = getCount();
        return varBufSnapshot.getByteArray(getVarBufOffset(), count);
    }
    public byte getByte() {
        return varBufSnapshot.getByte(getVarBufOffset());
    }
    public char[] getCharArray() {
        int count = getCount();
        byte[] temp = varBufSnapshot.getByteArray(getVarBufOffset(), count);
        char[] res = new char[count];
        for(int i = 0; i < count; i++) {
            res[i] = (char)temp[i];
        }
        return res;
    }
    public char getChar() {
        return (char)varBufSnapshot.getByte(getVarBufOffset());
    }
    public int[] getIntArray() {
        int count = getCount();
        return varBufSnapshot.getIntArray(getVarBufOffset(), count);
    }
    public int getInt() {
        return varBufSnapshot.getInt(getVarBufOffset());
    }
    public float[] getFloatArray() {
        int count = getCount();
        return varBufSnapshot.getFloatArray(getVarBufOffset(), count);
    }
    public float getFloat() {
        return varBufSnapshot.getFloat(getVarBufOffset());
    }
    public double[] getDoubleArray() {
        int count = getCount();
        return varBufSnapshot.getDoubleArray(getVarBufOffset(), count);
    }
    public double getDouble() {
        return varBufSnapshot.getDouble(getVarBufOffset());
    }
}
