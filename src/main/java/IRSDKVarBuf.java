import com.sun.jna.Pointer;

public class IRSDKVarBuf {
    public final int postWriteTickCount;
    public final int varsOffsetFromHeader;
    public int preWriteTickCount;

    public IRSDKVarBuf(Pointer sharedBuf, int offsetFromHeader) {
        postWriteTickCount = sharedBuf.getInt(offsetFromHeader);
        varsOffsetFromHeader = sharedBuf.getInt(offsetFromHeader + 4);
        preWriteTickCount = sharedBuf.getInt(offsetFromHeader + 8);
    }
}
