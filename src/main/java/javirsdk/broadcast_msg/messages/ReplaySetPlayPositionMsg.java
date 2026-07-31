package javirsdk.broadcast_msg.messages;

import javirsdk.broadcast_msg.JavirsdkBroadcastMsg;
import com.sun.jna.platform.win32.WinDef;

public class ReplaySetPlayPositionMsg extends JavirsdkBroadcastMsg {
    @Override
    public int getMsgOrder() {
        return 4;
    }

    public enum ReplaySetPlayPositionCommand {
        Begin(0),
        Current(1),
        End(2);

        private final int order;
        ReplaySetPlayPositionCommand(int order) {
            this.order = order;
        }
    }

    private final ReplaySetPlayPositionCommand command;
    private int numFramesFromCommand = 0;
    public ReplaySetPlayPositionMsg(ReplaySetPlayPositionCommand command) {
        this.command = command;
    }
    public ReplaySetPlayPositionMsg(ReplaySetPlayPositionCommand command, int numFramesFromCommand) {
        this.command = command;
        this.numFramesFromCommand = numFramesFromCommand;
    }

    @Override
    public WinDef.WPARAM getFirstParam() {
        int retVal = super.encodeIntsToHighLowInt(getMsgOrder(), command.order);
        return new WinDef.WPARAM(retVal);
    }
    @Override
    public WinDef.LPARAM getSecondParam() {
        return new WinDef.LPARAM(numFramesFromCommand);
    }
}
