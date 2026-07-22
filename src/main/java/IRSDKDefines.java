public class IRSDKDefines {
    public enum IRSDKVarType {
        IRSDK_CHAR,
        IRSDK_BOOL,
        IRSDK_INT,
        IRSDK_BITFIELD,
        IRSDK_FLOAT,
        IRSDK_DOUBLE
    }

    public static final String MEM_MAPPED_FILENAME = "Local\\IRSDKMemMapFileName";

    public static final int IRSDK_MAX_BUFS = 4;
    public static final int IRSDK_MAX_STRING = 32;
    public static final int IRSDK_MAX_DESC = 64;

    public static final int VAR_HEADER_SIZE_BYTE = 144;
}
