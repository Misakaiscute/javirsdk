import com.sun.jna.Pointer;

public class IRSDKVarBuf {
    private final int headerOffset;
    private final Pointer memSnapshot;

    public int getTickCount() {
        return memSnapshot.getInt(headerOffset);
    }
    public int getBufOffset() {
        return memSnapshot.getInt(headerOffset + 4);
    }
    public int getTickCountBegin() {
        return memSnapshot.getInt(headerOffset + 8);
    }

    public IRSDKVarBuf(Pointer buf, int offset) {
        headerOffset = offset;
        memSnapshot = buf;
    }

    public boolean[] getBooleans(int offset, int count) {
        byte[] temp = memSnapshot.getByteArray(headerOffset + offset, count);
        boolean[] res = new boolean[count];
        for(int i = 0; i < count; i++) {
            res[i] = temp[i] == 1;
        }
        return res;
    }
    public byte[] getBytes(int offset, int count) {
        return memSnapshot.getByteArray(headerOffset + offset, count);
    }
    public char[] getChars(int offset, int count) {
        byte[] temp = memSnapshot.getByteArray(headerOffset + offset, count);
        char[] res = new char[count];
        for(int i = 0; i < count; i++) {
            res[i] = (char)temp[i];
        }
        return res;
    }
    public int[] getInts(int offset, int count) {
        return memSnapshot.getIntArray(headerOffset + offset, count);
    }
    public float[] getFloats(int offset, int count) {
        return memSnapshot.getFloatArray(headerOffset + offset, count);
    }
    public double[] getDoubles(int offset, int count) {
        return memSnapshot.getDoubleArray(headerOffset + offset, count);
    }
}
