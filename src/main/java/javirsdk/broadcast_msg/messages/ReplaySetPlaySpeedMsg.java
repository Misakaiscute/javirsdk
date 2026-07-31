package javirsdk.broadcast_msg.messages;

import javirsdk.broadcast_msg.JavirsdkBroadcastMsg;
import com.sun.jna.platform.win32.WinDef;

// speed, slowMotion, unused
public class ReplaySetPlaySpeedMsg extends JavirsdkBroadcastMsg {
    @Override
    public int getMsgOrder() {
        return 3;
    }
    public enum ReplaySpeedMultiplierCommand {
        Backward16X(-16),
        Backward8X(-8),
        Backward4X(-4),
        Backward2X(-2),
        BackwardNormal(-1),
        Pause(0),
        ForwardNormal(1),
        Forward2X(2),
        Forward4X(4),
        Forward8X(8),
        Forward16X(16);

        private final int value;
        ReplaySpeedMultiplierCommand(int value) {
            this.value = value;
        }
    }

    private final ReplaySpeedMultiplierCommand command;
    private final boolean isSlowMo;
    public ReplaySetPlaySpeedMsg(ReplaySpeedMultiplierCommand command, boolean isSlowMo) {
        this.command = command;
        this.isSlowMo = isSlowMo;
    }

    @Override
    public WinDef.WPARAM getFirstParam() {
        int retVal = super.encodeIntsToHighLowInt(getMsgOrder(), command.value);
        return new WinDef.WPARAM(retVal);
    }
    @Override
    public WinDef.LPARAM getSecondParam() {
        return new WinDef.LPARAM(isSlowMo ? 1 : 0);
    }
}
