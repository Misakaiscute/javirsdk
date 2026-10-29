package javirsdk.handler;

import javirsdk.irsdkdef.IRSDKVarHeader;
import javirsdk.Javirsdk;
import javirsdk.variable.JavirsdkVariable;
import javirsdk.variable.JavirsdkVariableStateSnapshot;

import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Consumer;

public final class JavirsdkVariableHandler extends JavirsdkHandler<JavirsdkVariableStateSnapshot> {
    private final JavirsdkVariableStateSnapshot stateSnapshot;
    private final HashSet<JavirsdkVariable> variables;

    private JavirsdkVariableHandler(String id, int timeoutMs, int priority, Consumer<JavirsdkVariableStateSnapshot> handler, HashSet<JavirsdkVariable> reqVars) {
        super(id, timeoutMs, priority, handler);
        this.variables = reqVars;

        JavirsdkVariableStateSnapshot.Builder builder = new JavirsdkVariableStateSnapshot.Builder();
        registerVariables(builder);
        this.stateSnapshot = builder.build();
    }

    public static final class Builder extends JavirsdkHandler.Builder<Builder, JavirsdkVariableHandler, JavirsdkVariableStateSnapshot> {
        @Override
        protected Builder self() { return this; }

        private HashSet<JavirsdkVariable> hVariables = new HashSet<>();
        public Builder setRequiredVariables(JavirsdkVariable ... reqVars) {
            this.hVariables.addAll(Arrays.asList(reqVars));
            return this;
        }
        @Override 
        public JavirsdkVariableHandler build() {
            return new JavirsdkVariableHandler(hId, hTimeoutMs, hPriority, hHandler, hVariables);
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
    @Override
    public void executeBody() {
        //Update the state with the fresh data
        updateVariables();
        //Feed the updated state to the handler
        handler.accept(stateSnapshot);
    }
}
