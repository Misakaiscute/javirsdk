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

    public Boolean[] getBooleanArray() {
        int count = getCount();
        byte[] temp = varBufSnapshot.getByteArray(getVarBufOffset(), count);
        Boolean[] res = new Boolean[count];
        for(int i = 0; i < count; i++) {
            res[i] = temp[i] == 1;
        }
        return res;
    }
    public boolean getBoolean() {
        return varBufSnapshot.getByte(getVarBufOffset()) == 1;
    }
    public Character[] getCharArray() {
        int count = getCount();
        byte[] temp = varBufSnapshot.getByteArray(getVarBufOffset(), count);
        Character[] res = new Character[count];
        for(int i = 0; i < count; i++) {
            res[i] = (char)temp[i];
        }
        return res;
    }
    public char getChar() {
        return (char)varBufSnapshot.getByte(getVarBufOffset());
    }
    public Integer[] getIntArray() {
        int count = getCount();
        int[] temp = varBufSnapshot.getIntArray(getVarBufOffset(), count);
        Integer[] res = new Integer[count];
        for(int i = 0; i < count; i++) {
            res[i] = temp[i];
        }
        return res;
    }
    public int getInt() {
        return varBufSnapshot.getInt(getVarBufOffset());
    }
    public Float[] getFloatArray() {
        int count = getCount();
        float[] temp = varBufSnapshot.getFloatArray(getVarBufOffset(), count);
        Float[] res = new Float[count];
        for(int i = 0; i < count; i++) {
            res[i] = temp[i];
        }
        return res;
    }
    public float getFloat() {
        return varBufSnapshot.getFloat(getVarBufOffset());
    }
    public Double[] getDoubleArray() {
        int count = getCount();
        double[] temp = varBufSnapshot.getDoubleArray(getVarBufOffset(), count);
        Double[] res = new Double[count];
        for(int i = 0; i < count; i++) {
            res[i] = temp[i];
        }
        return res;
    }
    public double getDouble() {
        return varBufSnapshot.getDouble(getVarBufOffset());
    }
}
