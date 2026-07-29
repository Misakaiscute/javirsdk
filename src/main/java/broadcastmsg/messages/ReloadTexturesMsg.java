package broadcastmsg.messages;

import broadcastmsg.JavirsdkBroadcastMsg;
import com.sun.jna.platform.win32.WinDef;

public class ReloadTexturesMsg extends JavirsdkBroadcastMsg {
    @Override
    public int getMsgOrder() {
        return 7;
    }

    private final int ALL_TEXTURE_RELOAD_ORDER = 0;
    private final int CAR_IDX_RELOAD_ORDER = 1;

    private int carIdx = -1;
    public ReloadTexturesMsg(int carIdx) {
        this.carIdx = carIdx;
    }
    public ReloadTexturesMsg() {}

    @Override
    public WinDef.WPARAM getFirstParam() {
        int retVal;
        if (carIdx != -1) {
            retVal = super.encodeIntsToHighLowInt(getMsgOrder(), CAR_IDX_RELOAD_ORDER);
        } else {
            retVal = super.encodeIntsToHighLowInt(getMsgOrder(), ALL_TEXTURE_RELOAD_ORDER);
        }
        return new WinDef.WPARAM(retVal);
    }
    @Override
    public WinDef.LPARAM getSecondParam() {
        if (carIdx != -1) {
            return new WinDef.LPARAM(carIdx);
        }
        return new WinDef.LPARAM(0);
    }
}
