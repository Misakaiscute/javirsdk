package javirsdk.broadcast.messages;

import javirsdk.broadcast.JavirsdkBroadcastMsg;
import com.sun.jna.platform.win32.WinDef;

public class VideoCaptureMsg extends JavirsdkBroadcastMsg {
    @Override
    public int getMsgOrder() {
        return 13;
    }

    public enum VideoCaptureCommand {
        TRIGGER_SCREENSHOT(0), // save a screenshot to disk
        START_VIDEO_CAPTURE(1), // start capturing video
        END_VIDEO_CAPTURE(2), // stop capturing video
        TOGGLE_VIDEO_CAPTURE(3), // toggle video capture on/off
        SHOW_VIDEO_TIMER(4), // show video timer in upper left corner of display
        HIDE_VIDEO_TIMER(5); // hide video timer

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
