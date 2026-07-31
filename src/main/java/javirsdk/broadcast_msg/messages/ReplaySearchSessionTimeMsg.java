package javirsdk.broadcast_msg.messages;

import javirsdk.broadcast_msg.JavirsdkBroadcastMsg;
import com.sun.jna.platform.win32.WinDef;

// sessionNum, sessionTimeMS (high, low)
public class ReplaySearchSessionTimeMsg extends JavirsdkBroadcastMsg {
    @Override
    public int getMsgOrder() {
        return 12;
    }

    private final int sessionNum;
    private int sessionTimeMs = 0;

    public ReplaySearchSessionTimeMsg(int sessionNum) {
        this.sessionNum = sessionNum;
    }
    public ReplaySearchSessionTimeMsg(int sessionNum, int sessionTimeMs) {
        this.sessionNum = sessionNum;
        this.sessionTimeMs = sessionTimeMs;
    }

    @Override
    public WinDef.WPARAM getFirstParam() {
        int retVal = super.encodeIntsToHighLowInt(getMsgOrder(), sessionNum);
        return new WinDef.WPARAM(retVal);
    }
    @Override
    public WinDef.LPARAM getSecondParam() {
        return new WinDef.LPARAM(sessionTimeMs);
    }
}
