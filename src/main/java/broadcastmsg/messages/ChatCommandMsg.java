package broadcastmsg.messages;

import broadcastmsg.JavirsdkBroadcastMsg;
import com.sun.jna.platform.win32.WinDef;

public class ChatCommandMsg extends JavirsdkBroadcastMsg {
    @Override
    public int getMsgOrder() {
        return 8;
    }

    private final int MACRO_ORDER = 0;
    public enum ChatCommandCommand {
        BeginChat(1), // Open up a new chat window
        Reply(2), // Reply to the last private chat message
        Cancel(3); // Close out this chat window

        private final int order;
        ChatCommandCommand(int order) {
            this.order = order;
        }
    }

    private ChatCommandCommand command;
    private int macroNum = -1;
    public ChatCommandMsg(ChatCommandCommand command) {
        this.command = command;
    }
    public ChatCommandMsg(int macroNum) throws IllegalArgumentException {
        if (macroNum < 1 || macroNum > 15) {
            throw new IllegalArgumentException("Invalid macro number.");
        }
        this.macroNum = macroNum;
    }

    @Override
    public WinDef.WPARAM getFirstParam() {
        int retVal;
        if (macroNum != -1) {
            retVal = super.encodeIntsToHighLowInt(getMsgOrder(), MACRO_ORDER);
        } else {
            retVal = super.encodeIntsToHighLowInt(getMsgOrder(), command.order);
        }
        return new WinDef.WPARAM(retVal);
    }
    @Override
    public WinDef.LPARAM getSecondParam() {
        if (macroNum != -1) {
            return new WinDef.LPARAM(macroNum);
        }
        return new WinDef.LPARAM(0);
    }
}
