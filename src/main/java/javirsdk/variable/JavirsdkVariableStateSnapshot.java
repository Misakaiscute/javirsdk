package javirsdk.variable;

public final class JavirsdkVariableStateSnapshot {
    private JavirsdkVariableStateSnapshot() {}

    public float speed;
    public static class Builder {
        private JavirsdkVariableStateSnapshot INSTANCE;
        public Builder() {
            INSTANCE = new JavirsdkVariableStateSnapshot();
        }
        public JavirsdkVariableStateSnapshot build() {
            return INSTANCE;
        }
    }
}