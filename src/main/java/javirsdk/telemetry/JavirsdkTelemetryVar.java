package javirsdk.telemetry;

import irsdkdef.IRSDKVarType;

//All the telemetry variables inherit from this abstract class.
//The names of classes are very intentional, because it encodes the
//name of the IRSDK variable in its name following the "JavirsdkVar" string.
//So the IRSDK variable "AirDensity" (that has to be first scouted to
//obtain its IRSDKVarHeader) would be "JavirsdkVarAirDensity"
public abstract class JavirsdkTelemetryVar<T> {
    private final String childClsName = getClass().getSimpleName();
    public final String varName = childClsName.substring(11, childClsName.length() - 1);

    protected T value;
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
    protected <_T extends T> JavirsdkTelemetryVar(_T initialValue) {
        value = initialValue;
    }

    public abstract IRSDKVarType getType();
}
