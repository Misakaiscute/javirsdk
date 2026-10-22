package javirsdk.broadcast.messages;

import javirsdk.broadcast.JavirsdkBroadcastMsg;
import com.sun.jna.platform.win32.WinDef;

// irsdk_PitCommandMode, parameter
public class PitCommandMsg extends JavirsdkBroadcastMsg {
    @Override
    public int getMsgOrder() {
        return 9;
    }

    public enum PitCommandCommand {
        UNCHECK_ALL(0), // Clear all pit checkboxes
        WINDSHIELD_TEAROFF(1), // Clean the windshield, using one tear off
        UNCHECK_TYRE(7), // Clear tire pit checkboxes
        FAST_REPAIR(8), // Request a fast repair
        UNCHECK_WINDSHIELD_TEAROFF(9), // Uncheck Clean the windshield checkbox
        UNCHECK_FAST_REPAIR(10), // Uncheck request a fast repair
        UNCHECK_BEGIN_REFUEL(11), // Uncheck add fuel
        CHANGE_TYRE_COMPOUND(12); // Change tire compound

        private final int order;
        PitCommandCommand(int order) {
            this.order = order;
        }
    }

    public enum ChangeTyreCommand {
        LF(3), // Change the left front tire, optionally specifying the pressure in KPa or pass '0' to use existing pressure
        RF(4), // right front
        LR(5), // left rear
        RR(6); // right rear

        private final int order;
        ChangeTyreCommand(int order) {
            this.order = order;
        }
    }

    public enum StartRefuelCommand {
        FUEL(2); // Add fuel, optionally specify the amount to add in liters or pass '0' to use existing amount

        private final int order;
        StartRefuelCommand(int order) {
            this.order = order;
        }
    }

    private PitCommandCommand genericCommand = null;
    public PitCommandMsg(PitCommandCommand command) {
        this.genericCommand = command;
    }

    private StartRefuelCommand startRefuelCommand = null;
    private int refuelAmount = 0;
    public PitCommandMsg(StartRefuelCommand command, int refuelAmount) {
        this.startRefuelCommand = command;
        this.refuelAmount = refuelAmount;
    }

    private ChangeTyreCommand changeTyreCommand = null;
    private int pressurePsi = 0;
    public PitCommandMsg(ChangeTyreCommand command, int pressurePsi) {
        this.changeTyreCommand = command;
        this.pressurePsi = pressurePsi;
    }

    @Override
    public WinDef.WPARAM getFirstParam() {
        int retVal;
        if (genericCommand != null) {
            retVal = super.encodeIntsToHighLowInt(getMsgOrder(), genericCommand.order);
        } else if (startRefuelCommand != null) {
            retVal = super.encodeIntsToHighLowInt(getMsgOrder(), startRefuelCommand.order);
        } else {
            retVal = super.encodeIntsToHighLowInt(getMsgOrder(), changeTyreCommand.order);
        }
        return new WinDef.WPARAM(retVal);
    }
    @Override
    public WinDef.LPARAM getSecondParam() {
        if (startRefuelCommand != null) {
            return new WinDef.LPARAM(refuelAmount);
        } else if (changeTyreCommand != null) {
            return new WinDef.LPARAM(pressurePsi);
        }
        return new WinDef.LPARAM(0);
    }
}
