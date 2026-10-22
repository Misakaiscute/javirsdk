package javirsdk.broadcast.messages;

import javirsdk.broadcast.JavirsdkBroadcastMsg;
import com.sun.jna.platform.win32.WinDef;

// speed, slowMotion, unused
public class ReplaySetPlaySpeedMsg extends JavirsdkBroadcastMsg {
    @Override
    public int getMsgOrder() {
        return 3;
    }
    public enum ReplaySpeedMultiplierCommand {
        BACKWARD_16X(-16),
        BACKWARD_12X(-12),
        BACKWARD_8X(-8),
        BACKWARD_4X(-4),
        BACKWARD_2X(-2),
        BACKWARD_1X(-1),
        PAUSE(0),
        FORWARD_1X(1),
        FORWARD_2X(2),
        FORWARD_4X(4),
        FORWARD_8X(8),
        FORWARD_12X(12),
        FORWARD_16X(16);

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
