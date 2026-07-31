package javirsdk.broadcast_msg.messages;

import javirsdk.broadcast_msg.JavirsdkBroadcastMsg;
import com.sun.jna.platform.win32.WinDef;

public class ReplaySearchMsg extends JavirsdkBroadcastMsg {
    @Override
    public int getMsgOrder() {
        return 5;
    }

    public enum ReplaySearchCommand {
        ToStart(0),
        ToEnd(1),
        PrevSession(2),
        NextSession(3),
        PrevLap(4),
        NextLap(5),
        PrevFrame(6),
        NextFrame(7),
        PrevIncident(8),
        NextIncident(9);

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
