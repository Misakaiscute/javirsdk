package javirsdk.broadcast_msg.messages;

import javirsdk.broadcast_msg.JavirsdkBroadcastMsg;
import com.sun.jna.platform.win32.WinDef;

public class ReplaySetStateMsg extends JavirsdkBroadcastMsg {
    @Override
    public int getMsgOrder() {
        return 6;
    }

    public enum ReplaySetStateCommand {
        EraseTape(0);

        private final int order;
        ReplaySetStateCommand(int order) {
            this.order = order;
        }
    }

    private final ReplaySetStateCommand command;
    public ReplaySetStateMsg(ReplaySetStateCommand command) {
        this.command = command;
    }

    @Override
    public WinDef.WPARAM getFirstParam() {
        int retVal = super.encodeIntsToHighLowInt(getMsgOrder(), command.order);
        return new WinDef.WPARAM(retVal);
    }
}
