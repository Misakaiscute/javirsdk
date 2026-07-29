package broadcastmsg.messages;

import broadcastmsg.JavirsdkBroadcastMsg;
import com.sun.jna.platform.win32.WinDef;

public class CamSetStateMsg extends JavirsdkBroadcastMsg {
    @Override
    public int getMsgOrder() {
        return 2;
    }
    public enum CamSetStateCommand {
        CamToolActive(0x0004),
        UIHidden(0x0008),
        UseAutoShotSelection(0x0010),
        UseTemporaryEdits(0x0020),
        UseKeyAcceleration(0x0040),
        UseKey10xAcceleration(0x0080),
        UseMouseAimMode(0x0100);

        private final int value;
        CamSetStateCommand(int value) {
            this.value = value;
        }
    }
    private final CamSetStateCommand command;
    public CamSetStateMsg(CamSetStateCommand command) {
        this.command = command;
    }

    @Override
    public WinDef.WPARAM getFirstParam() {
        int retVal = super.encodeIntsToHighLowInt(getMsgOrder(), command.value);
        return new WinDef.WPARAM(retVal);
    }
}
