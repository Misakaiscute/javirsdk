package javirsdk.broadcast.messages;

import javirsdk.broadcast.JavirsdkBroadcastMsg;
import com.sun.jna.platform.win32.WinDef;

public class TelemetryMsg extends JavirsdkBroadcastMsg {
    @Override
    public int getMsgOrder() {
        return 10;
    }

    public enum TelemetryCommand {
        STOP_RECORDING(0), // Turn telemetry recording off
        START_RECORDING(1), // Turn telemetry recording on
        RESTART_RECORDING(2); // Write current file to disk and start a new one

        private final int order;
        TelemetryCommand(int order) {
            this.order = order;
        }
    }

    private final TelemetryCommand command;
    private TelemetryMsg(TelemetryCommand command) {
        this.command = command;
    }

    @Override
    public WinDef.WPARAM getFirstParam() {
        int retVal = super.encodeIntsToHighLowInt(getMsgOrder(), command.order);
        return new WinDef.WPARAM(retVal);
    }
}
