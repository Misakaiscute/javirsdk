package javirsdk.broadcast.messages;

import javirsdk.broadcast.JavirsdkBroadcastMsg;
import com.sun.jna.platform.win32.WinDef;

public class ReplaySearchMsg extends JavirsdkBroadcastMsg {
    @Override
    public int getMsgOrder() {
        return 5;
    }

    public enum ReplaySearchCommand {
        TO_START(0),
        TO_END(1),
        PREV_SESSION(2),
        NEXT_SESSION(3),
        PREV_LAP(4),
        NEXT_LAP(5),
        PREV_FRAME(6),
        NEXT_FRAME(7),
        PREV_INCIDENT(8),
        NEXT_INCIDENT(9);

        private final int order;
        ReplaySearchCommand(int order) {
            this.order = order;
        }
    }

    private final ReplaySearchCommand command;
    public ReplaySearchMsg(ReplaySearchCommand command) {
        this.command = command;
    }

    @Override
    public WinDef.WPARAM getFirstParam() {
        int retVal = super.encodeIntsToHighLowInt(getMsgOrder(), command.order);
        return new WinDef.WPARAM(retVal);
    }
}
