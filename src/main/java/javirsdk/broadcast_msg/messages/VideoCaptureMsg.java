package javirsdk.broadcast_msg.messages;

import javirsdk.broadcast_msg.JavirsdkBroadcastMsg;
import com.sun.jna.platform.win32.WinDef;

public class VideoCaptureMsg extends JavirsdkBroadcastMsg {
    @Override
    public int getMsgOrder() {
        return 13;
    }

    public enum VideoCaptureCommand {
        TriggerScreenShot(0), // save a screenshot to disk
        StartVideoCapture(1), // start capturing video
        EndVideoCapture(2), // stop capturing video
        ToggleVideoCapture(3), // toggle video capture on/off
        ShowVideoTimer(4), // show video timer in upper left corner of display
        HideVideoTimer(5); // hide video timer

        private final int order;
        VideoCaptureCommand(int order) {
            this.order = order;
        }
    }

    private final VideoCaptureCommand command;
    public VideoCaptureMsg(VideoCaptureCommand command) {
        this.command = command;
    }

    @Override
    public WinDef.WPARAM getFirstParam() {
        int retVal = super.encodeIntsToHighLowInt(getMsgOrder(), command.order);
        return new WinDef.WPARAM(retVal);
    }
}