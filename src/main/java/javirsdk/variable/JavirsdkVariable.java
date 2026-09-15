package javirsdk.variable;

import irsdkdef.IRSDKVarType;

import java.util.function.BiConsumer;

public enum JavirsdkVariable {
    ;
    private final String name;
    public String getName() {
        return name;
    }
    private final IRSDKVarType type;
    public IRSDKVarType getType() {
        return type;
    }
    private final boolean isArray;
    public boolean isArray() {
        return isArray;
    }
    private final BiConsumer<JavirsdkVariableStateSnapshot.Builder, Object> registerHandler;
    public void invokeRegisterHandler(JavirsdkVariableStateSnapshot.Builder builder, Object value) {
        registerHandler.accept(builder, value);
    }
    private final BiConsumer<JavirsdkVariableStateSnapshot, Object> updateHandler;
    public void invokeUpdateHandler(JavirsdkVariableStateSnapshot snapshotState, Object value) {
        updateHandler.accept(snapshotState, value);
    }

    JavirsdkVariable(
        String name,
        IRSDKVarType type,
        boolean isArray,
        BiConsumer<JavirsdkVariableStateSnapshot.Builder, Object> registerHandler,
        BiConsumer<JavirsdkVariableStateSnapshot, Object> updateHandler
    ) {
        this.name = name;
        this.type = type;
        this.isArray = isArray;
        this.registerHandler = registerHandler;
        this.updateHandler = updateHandler;
    }
}