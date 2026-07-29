package broadcastmsg.messages;

import broadcastmsg.JavirsdkBroadcastMsg;
import com.sun.jna.platform.win32.WinDef;

// irsdk_FFBCommandMode, value (float, high, low)
public class FFBCommandMsg extends JavirsdkBroadcastMsg {
    @Override
    public int getMsgOrder() {
        return 11;
    }

    public enum FFBCommandCommand {
        SetMaxForce(0);

        private final int order;
        FFBCommandCommand(int order) {
            this.order = order;
        }
    }
    private final FFBCommandCommand command;
    private final float value;

    public FFBCommandMsg(FFBCommandCommand command, float value) {
        this.command = command;
        this.value = value;
    }

    @Override
    public WinDef.WPARAM getFirstParam() {
        int retVal = super.encodeIntsToHighLowInt(getMsgOrder(), command.order);
        return new WinDef.WPARAM(retVal);
    }
    @Override
    public WinDef.LPARAM getSecondParam() {
        return new WinDef.LPARAM(super.floatToHighLowInt(value));
    }
}
