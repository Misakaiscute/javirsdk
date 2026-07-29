package broadcastmsg;

import com.sun.jna.platform.win32.WinDef;

public abstract class JavirsdkBroadcastMsg {
    public abstract int getMsgOrder();
    public WinDef.WPARAM getFirstParam() {
        return new WinDef.WPARAM(0);
    }
    public WinDef.LPARAM getSecondParam() {
        return new WinDef.LPARAM(0);
    }

    protected int floatToHighLowInt(float f) {
        return (int)(f * 65_535); // 2^16 - 1
    }
    protected int padCarNumber(int num, int zeros) {
        int numLength = 1;
        if (num > 99) {
            numLength = 3;
        } else if (num > 9) {
            numLength = 2;
        }
        return (numLength + zeros) * 1000 + num;
    }
    protected int padCarNumber(char[] num) {
        int numLength = num.length;
        int decPlace = 1;
        int numParsed = 0;
        for (int i = numLength - 1; i >= 0; i--) {
            int fromAscii = (int)num[i] - 48;
            if (fromAscii <= 9 && fromAscii >= 0) {
                numParsed += fromAscii * decPlace;
                decPlace = decPlace * 10;
            } else {
                numLength--;
            }
        }
        return numLength * 1000 + numParsed;
    }
    protected int encodeIntsToHighLowInt(int a, int b) {
        int low  = a & 0xFFFF;
        int high = b & 0xFFFF;
        return (high << 16) | low;
    }
}