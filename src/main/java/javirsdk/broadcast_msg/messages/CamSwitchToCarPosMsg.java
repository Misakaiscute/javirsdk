package javirsdk.broadcast_msg.messages;

import javirsdk.broadcast_msg.JavirsdkBroadcastMsg;
import com.sun.jna.platform.win32.WinDef;

public class CamSwitchToCarPosMsg extends JavirsdkBroadcastMsg {
    @Override
    public int getMsgOrder() {
        return 0;
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
    private int carPos;
    private int camGroupNum = 0;
    private int camNum = 0;

    public CamSwitchToCarPosMsg(FocusOnCommand command, int camGroupNum, int camNum) {
        this.command = command;
        this.camGroupNum = camGroupNum;
        this.camNum = camNum;
    }
    public CamSwitchToCarPosMsg(FocusOnCommand command) {
        this.command = command;
    }
    public CamSwitchToCarPosMsg(int carPos, int camGroupNum, int camNum) {
        this.carPos = carPos;
        this.camGroupNum = camGroupNum;
        this.camNum = camNum;
    }
    public CamSwitchToCarPosMsg(int carPos) {
        this.carPos = carPos;
    }

    @Override
    public WinDef.WPARAM getFirstParam() {
        int retVal;
        if (command != null) {
            retVal = super.encodeIntsToHighLowInt(getMsgOrder(), command.order);
        } else {
            retVal = super.encodeIntsToHighLowInt(getMsgOrder(), carPos);
        }
        return new WinDef.WPARAM(retVal);
    }
    @Override
    public WinDef.LPARAM getSecondParam() {
        int retVal = super.encodeIntsToHighLowInt(camGroupNum, camNum);
        return new WinDef.LPARAM(retVal);
    }
}
