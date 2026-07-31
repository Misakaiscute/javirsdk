package javirsdk.telemetry.variables;

import irsdkdef.IRSDKVarType;
import javirsdk.telemetry.JavirsdkTelemetryVar;

public final class JavirsdkVarAirPressure extends JavirsdkTelemetryVar<Float> {
    public JavirsdkVarAirPressure() {
        super(0f);
    }
    @Override
    public IRSDKVarType getType() {
        return IRSDKVarType.IRSDK_FLOAT;
    }
}