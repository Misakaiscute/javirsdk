package javirsdk;

import irsdkdef.IRSDKVarHeader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class JavirsdkTelemetryVariableScouter {
    private static final String JavirsdkVariableEnumFrame = """
        package javirsdk.variable;
            
        import irsdkdef.IRSDKVarType;
    
        import java.util.function.BiConsumer;
    
        public enum JavirsdkVariable {
            %s;
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
    """;

    private static final String JavirsdkVariableStateSnapshotFrame = """
        package javirsdk.variable;
            
        public final class JavirsdkVariableStateSnapshot {
            private JavirsdkVariableStateSnapshot() {}
            
            %s
    
            public static class Builder {
                private JavirsdkVariableStateSnapshot INSTANCE;
                public Builder() {
                    INSTANCE = new JavirsdkVariableStateSnapshot();
                }
                public JavirsdkVariableStateSnapshot build() {
                    return INSTANCE;
                }
                %s
            }
        }
    """;

    public static void main(String[] args) {
        try {
            Javirsdk.getInstance().openConnection();
            Javirsdk.getInstance().waitForNewData();
            IRSDKVarHeader[] varHeaders = Javirsdk.getInstance().scoutVarHeaderNames();

            StringBuilder JavirsdkVariableEnumContent = new StringBuilder();
            StringBuilder JavirsdkVariableStateSnapshotContent = new StringBuilder();
            StringBuilder JavirsdkVariableStateSnapshotBuilderContent = new StringBuilder();
            for (int i = 0; i < varHeaders.length; ++i) {
                System.out.printf("\\u001B[1m\\u001B[32mScouting variable %s\\u001B[39m\\u001B[22m\n", varHeaders[i].getName());

                String enumEntry = produceVariableEnumEntry(varHeaders[i]);
                String stateEntry = produceVariableStateSnapshotEntry(varHeaders[i]);
                String stateBuilderSetter = produceVariableStateSnapshotEntryBuilder(varHeaders[i]);

                if (i == varHeaders.length - 1) {
                    JavirsdkVariableEnumContent.append(enumEntry);
                } else {
                    JavirsdkVariableEnumContent.append(enumEntry).append(",\n");
                }
                JavirsdkVariableStateSnapshotContent.append(stateEntry).append("\n");
                JavirsdkVariableStateSnapshotBuilderContent.append(stateBuilderSetter).append("\n");
            }
            String JavirsdkVariableEnumConcat = JavirsdkVariableEnumFrame.formatted(JavirsdkVariableEnumContent.toString());
            String JavirsdkVariableStateSnapshotConcat = JavirsdkVariableStateSnapshotFrame.formatted(JavirsdkVariableStateSnapshotContent.toString(), JavirsdkVariableStateSnapshotBuilderContent.toString());
            
            Path path = Path.of("src/main/java/javirsdk/variable/");
            Files.writeString(path.resolve("JavirsdkVariable.java"), JavirsdkVariableEnumConcat);
            Files.writeString(path.resolve("JavirsdkVariableStateSnapshot.java"), JavirsdkVariableStateSnapshotConcat);
        } catch (IOException e) {
            System.out.printf("\u001B[1m\u001B[31m%s error: %s\u001B[39m\u001B[22m%n", JavirsdkTelemetryVariableScouter.class.getName(), e.getMessage());
        }
    }

    private static String produceVariableStateSnapshotEntry(IRSDKVarHeader varHeader) {
        /*public Double[] getSessionTime() { 
            return this.sessionTime;
        }
        public void setSessionTime(Double[] v) {
            this.sessionTime = v;
        }*/
        boolean isArray = varHeader.getCount() > 1;
        String type = typeAsString(varHeader) + (isArray ? "[]" : "");
        String fieldName = firstCharLower(varHeader.getName());

        String backingField = "private %s %s = %s;".formatted(type, fieldName, defaultValueAsString(varHeader, isArray));
        String getter = "public %s get%s() { return this.%s; }".formatted(type, varHeader.getName(), fieldName);
        String setter = "public void set%s(%s v) { this.%s = v; }".formatted(varHeader.getName(), type, fieldName);

        StringBuilder entry = new StringBuilder();
        entry.append(backingField).append("\n");
        entry.append(getter).append("\n");
        entry.append(setter).append("\n");

        return entry.toString();
    }
    private static String produceVariableStateSnapshotEntryBuilder(IRSDKVarHeader varHeader) {
        /*public Builder setSessionTime(Double[] v) {
            this.INSTANCE.sessionTime = v;
            return this;
        }*/ 
        boolean isArray = varHeader.getCount() > 1;
        String type = typeAsString(varHeader) + (isArray ? "[]" : "");
        String fieldName = firstCharLower(varHeader.getName());
  
        String setter = "public Builder set%s(%s v) { this.INSTANCE.%s = v; return this; }".formatted(varHeader.getName(), type, fieldName);
        return setter;
    }

    private static String produceVariableEnumEntry(IRSDKVarHeader varHeader) {
        //SESSIONTIME("SessionTime", IRSDKVarType.IRSDK_DOUBLE, true, (JavirsdkVariableStateSnapshot.Builder b, Object v) -> { b.setSessionTime((Double[])v); }, (JavirsdkVariableStateSnapshot s, Object v) -> { s.setSessionTime((Double[])v); });
        boolean isArray = varHeader.getCount() > 1;
        String registerHandler = "(JavirsdkVariableStateSnapshot.Builder b, Object v) -> { b.set%s((%s) v); }".formatted(
            varHeader.getName(), // fn name
            isArray ? typeAsString(varHeader) + "[]" : typeAsString(varHeader) // cast
        );
        String updateHandler = "(JavirsdkVariableStateSnapshot s, Object v) -> { s.set%s((%s) v); }".formatted(
            varHeader.getName(), // fn name
            isArray ? typeAsString(varHeader) + "[]" : typeAsString(varHeader) // cast
        );

        return "%s(\"%s\", IRSDKVarType.%s, %s, %s, %s)".formatted(
            varHeader.getName().toUpperCase(),
            varHeader.getName(),
            varHeader.getType(),
            isArray,
            registerHandler,
            updateHandler
        );
    }

    private static String firstCharLower(String str) {
        char[] strArr = str.toCharArray();
        strArr[0] = Character.toLowerCase(strArr[0]);

        return new String(strArr);
    }

    private static String typeAsString(IRSDKVarHeader varHeader) {
        switch (varHeader.getType()) {
            case IRSDK_CHAR -> {
                return "Character";
            }
            case IRSDK_BOOL -> {
                return "Boolean";
            }
            case IRSDK_INT, IRSDK_BITFIELD -> {
                return "Integer";
            }
            case IRSDK_FLOAT -> {
                return "Float";
            }
            case IRSDK_DOUBLE -> {
                return "Double";
            }
            default -> {
                return "Object";
            }
        }
    }
    private static String defaultValueAsString(IRSDKVarHeader varHeader, boolean isArray) {
        switch (varHeader.getType()) {
            case IRSDK_CHAR -> {
                return isArray ? "new Character[]{'a'}" : "a";
            }
            case IRSDK_BOOL -> {
                return isArray ? "new Boolean[]{false}" : "false";
            }
            case IRSDK_INT, IRSDK_BITFIELD -> {
                return isArray ? "new Integer[]{0}" : "0";
            }
            case IRSDK_FLOAT -> {
                return isArray ? "new Float[]{0f}" : "0f";
            }
            case IRSDK_DOUBLE -> {
                return isArray ? "new Double[]{0.0}" : "0.0";
            }
            default -> {
                return "null";
            }
        }
    }
}
