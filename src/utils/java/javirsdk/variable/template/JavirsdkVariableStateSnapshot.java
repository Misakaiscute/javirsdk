    package javirsdk.variable.template;

    public final class JavirsdkVariableStateSnapshot {
        private JavirsdkVariableStateSnapshot() {}

        private Double[] sessionTime = new Double[] {};
        public Double[] getSessionTime() { 
            return this.sessionTime;
        }
        public void setSessionTime(Double[] v) {
            this.sessionTime = v;
        }

        public static class Builder {
            private JavirsdkVariableStateSnapshot INSTANCE;
            public Builder() {
                INSTANCE = new JavirsdkVariableStateSnapshot();
            }
            public JavirsdkVariableStateSnapshot build() {
                return INSTANCE;
            }
            public Builder setSessionTime(Double[] v) {
                this.INSTANCE.sessionTime = v;
                return this;
            }
        }
    }
