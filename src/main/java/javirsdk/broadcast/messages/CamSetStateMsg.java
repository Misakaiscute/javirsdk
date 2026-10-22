package javirsdk.broadcast.messages;

import javirsdk.broadcast.JavirsdkBroadcastMsg;
import com.sun.jna.platform.win32.WinDef;

public class CamSetStateMsg extends JavirsdkBroadcastMsg {
    @Override
    public int getMsgOrder() {
        return 2;
    }
    public enum CamSetStateCommand {
        ACTIVATE_CAM_TOOL(0x0004),
        HIDE_UI(0x0008),
        USE_AUTO_SHOT_SELECTION(0x0010),
        USE_TEMPORARY_EDITS(0x0020),
        USE_KEY_ACCELERATION(0x0040),
        USE_KEY_TENX_ACCELERATION(0x0080),
        USE_MOUSE_AIM_MODE(0x0100);

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
