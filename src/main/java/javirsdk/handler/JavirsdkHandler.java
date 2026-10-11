package javirsdk.handler;

import irsdkdef.IRSDKVarHeader;
import javirsdk.Javirsdk;
import javirsdk.variable.JavirsdkVariable;
import javirsdk.variable.JavirsdkVariableStateSnapshot;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Consumer;

public class JavirsdkHandler {
    private final String id;
    public String getId() {
        return this.id;
    }
    private final JavirsdkVariableStateSnapshot stateSnapshot;
    private final Consumer<JavirsdkVariableStateSnapshot> handler;
    private final HashSet<JavirsdkVariable> variables;

    private JavirsdkHandler(String id, Consumer<JavirsdkVariableStateSnapshot> handler, HashSet<JavirsdkVariable> reqVars) {
        this.id = id;
        this.handler = handler;
        this.variables = reqVars;

        JavirsdkVariableStateSnapshot.Builder builder = new JavirsdkVariableStateSnapshot.Builder();
        registerVariables(builder);
        this.stateSnapshot = builder.build();
    }

    public static final class Builder {
        private String hId;
        public Builder setId(String hId) {
            this.hId = hId;
            return this;
        }
        private Consumer<JavirsdkVariableStateSnapshot> hHandler;
        public Builder setHandler(Consumer<JavirsdkVariableStateSnapshot> handler) {
            this.hHandler = handler;
            return this;
        }
        private HashSet<JavirsdkVariable> hVariables = new HashSet<>();
        public Builder setRequiredVariables(JavirsdkVariable ... reqVars) {
            this.hVariables.addAll(Arrays.asList(reqVars));
            return this;
        }

        public JavirsdkHandler build() {
            return new JavirsdkHandler(hId, hHandler, hVariables);
        }
    }

    private void registerVariables(JavirsdkVariableStateSnapshot.Builder builder) {
        variables.forEach((JavirsdkVariable var) -> {
            if (var.isArray()){
                switch (var.getType()) {
                    case IRSDK_CHAR -> var.invokeRegisterHandler(builder, new char[0]);
                    case IRSDK_BOOL -> var.invokeRegisterHandler(builder, new boolean[0]);
                    case IRSDK_INT, IRSDK_BITFIELD -> var.invokeRegisterHandler(builder, new int[0]);
                    case IRSDK_FLOAT -> var.invokeRegisterHandler(builder, new float[0]);
                    case IRSDK_DOUBLE -> var.invokeRegisterHandler(builder, new double[0]);
                }
            } else {
                switch (var.getType()) {
                    case IRSDK_CHAR -> var.invokeRegisterHandler(builder, 'a');
                    case IRSDK_BOOL -> var.invokeRegisterHandler(builder, false);
                    case IRSDK_INT, IRSDK_BITFIELD -> var.invokeRegisterHandler(builder, 0);
                    case IRSDK_FLOAT -> var.invokeRegisterHandler(builder, 0f);
                    case IRSDK_DOUBLE -> var.invokeRegisterHandler(builder, 0d);
                }
            }
        });
    }
    private void updateVariables() {
        variables.forEach((JavirsdkVariable var) -> {
            IRSDKVarHeader varHeader = Javirsdk.getInstance().getVarHeaderByName(var.getName());
            if (var.isArray()){
                switch (varHeader.getType()) {
                    case IRSDK_CHAR -> var.invokeUpdateHandler(stateSnapshot, varHeader.getCharArray());
                    case IRSDK_BOOL -> var.invokeUpdateHandler(stateSnapshot, varHeader.getBooleanArray());
                    case IRSDK_INT, IRSDK_BITFIELD -> var.invokeUpdateHandler(stateSnapshot, varHeader.getIntArray());
                    case IRSDK_FLOAT -> var.invokeUpdateHandler(stateSnapshot, varHeader.getFloatArray());
                    case IRSDK_DOUBLE -> var.invokeUpdateHandler(stateSnapshot, varHeader.getDoubleArray());
                }
            } else {
                switch (varHeader.getType()) {
                    case IRSDK_CHAR -> var.invokeUpdateHandler(stateSnapshot, varHeader.getChar());
                    case IRSDK_BOOL -> var.invokeUpdateHandler(stateSnapshot, varHeader.getBoolean());
                    case IRSDK_INT, IRSDK_BITFIELD -> var.invokeUpdateHandler(stateSnapshot, varHeader.getInt());
                    case IRSDK_FLOAT -> var.invokeUpdateHandler(stateSnapshot, varHeader.getFloat());
                    case IRSDK_DOUBLE -> var.invokeUpdateHandler(stateSnapshot, varHeader.getDouble());
                }
            }
        });
    }

    public void execute() {
        //Update the state with the fresh data
        updateVariables();
        //Feed the updated state to the handler
        handler.accept(stateSnapshot);
    }
}
