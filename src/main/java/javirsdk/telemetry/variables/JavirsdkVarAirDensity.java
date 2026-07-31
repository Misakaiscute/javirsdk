package javirsdk.telemetry.variables;

import irsdkdef.IRSDKVarType;
import javirsdk.telemetry.JavirsdkTelemetryVar;

public final class JavirsdkVarAirDensity extends JavirsdkTelemetryVar<Float> {
    public JavirsdkVarAirDensity() {
        super(0f);
    }
    @Override
    public IRSDKVarType getType() {
        return IRSDKVarType.IRSDK_FLOAT;
    }
}
