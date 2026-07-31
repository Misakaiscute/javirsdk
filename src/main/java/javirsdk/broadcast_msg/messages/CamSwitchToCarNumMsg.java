package javirsdk.broadcast_msg.messages;

import javirsdk.broadcast_msg.JavirsdkBroadcastMsg;
import com.sun.jna.platform.win32.WinDef;

public class CamSwitchToCarNumMsg extends JavirsdkBroadcastMsg {
    @Override
    public int getMsgOrder() {
        return 1;
    }
    public enum FocusOnCommand {
        Incident(-3),
        Leader(-2),
        Exiting(-1);

        private final int order;
        FocusOnCommand(int order) {
            this.order = order;
        }
    }

    private FocusOnCommand command;
    private int carNumPadded;
    private int camGroupNum = 0;
    private int camNum = 0;

    public CamSwitchToCarNumMsg(FocusOnCommand command, int camGroupNum, int camNum) {
        this.command = command;
        this.camGroupNum = camGroupNum;
        this.camNum = camNum;
    }
    public CamSwitchToCarNumMsg(FocusOnCommand command) {
        this.command = command;
    }
    public CamSwitchToCarNumMsg(char[] carNum, int camGroupNum, int camNum) {
        this.carNumPadded = super.padCarNumber(carNum);
        this.camGroupNum = camGroupNum;
        this.camNum = camNum;
    }
    public CamSwitchToCarNumMsg(char[] carNum) {
        this.carNumPadded = super.padCarNumber(carNum);
    }

    @Override
    public WinDef.WPARAM getFirstParam() {
        int retVal;
        if (command != null) {
            retVal = super.encodeIntsToHighLowInt(getMsgOrder(), command.order);
        } else {
            retVal = super.encodeIntsToHighLowInt(getMsgOrder(), carNumPadded);
        }
        return new WinDef.WPARAM(retVal);
    }
    @Override
    public WinDef.LPARAM getSecondParam() {
        int highLowInt = super.encodeIntsToHighLowInt(camGroupNum, camNum);
        return new WinDef.LPARAM(highLowInt);
    }
}
