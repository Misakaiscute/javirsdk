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
            for (int i = 0; i < varHeaders.length; ++i) {
                System.out.printf("\\u001B[1m\\u001B[32mScouting variable %s\\u001B[39m\\u001B[22m\n", varHeaders[i].getName());
                String enumBody = produceVariableEnumEntry(varHeaders[i]);
                String stateClassBody = produceVariableStateSnapshotEntry(varHeaders[i]);
                if (i == varHeaders.length - 1) {
                    JavirsdkVariableEnumContent.append(enumBody);
                } else {
                    JavirsdkVariableEnumContent.append(enumBody).append(",\n");
                }
                JavirsdkVariableStateSnapshotContent.append(stateClassBody).append("\n");
            }
            String JavirsdkVariableEnumConcat = JavirsdkVariableEnumFrame.formatted(JavirsdkVariableEnumContent.toString());
            String JavirsdkVariableStateSnapshotConcat = JavirsdkVariableStateSnapshotFrame.formatted(JavirsdkVariableStateSnapshotContent.toString());
            
            Path path = Path.of("../../../../main/java/javirsdk/variable/");
            Files.writeString(path.resolve("JavirsdkVariable"), JavirsdkVariableEnumConcat);
            Files.writeString(path.resolve("JavirsdkVariableStateSnapshot"), JavirsdkVariableStateSnapshotConcat);
        } catch (IOException e) {
            System.out.printf("\u001B[1m\u001B[31m%s error: %s\u001B[39m\u001B[22m%n", JavirsdkTelemetryVariableScouter.class.getName(), e.getMessage());
        }
    }

    private static String produceVariableStateSnapshotEntry(IRSDKVarHeader varHeader) {
        boolean isArray = varHeader.getCount() > 0;
        String type = typeAsString(varHeader) + (isArray ? "[]" : "");
        String fieldName = firstCharLower(varHeader.getName());

        String backingField = "private %s %s = %s;".formatted(type, fieldName, defaultValueAsString(varHeader));
        String getter = "public %s get%s() { return this.%s; }".formatted(type, varHeader.getName(), fieldName);
        String setter = "public void set%s(%s v) { this.%s = v; }".formatted(varHeader.getName(), type, fieldName);

        StringBuilder entry = new StringBuilder();
        entry.append(backingField).append("\n");
        entry.append(getter).append("\n");
        entry.append(setter).append("\n");

        return entry.toString();
    }

    private static String produceVariableEnumEntry(IRSDKVarHeader varHeader) {
        boolean isArray = varHeader.getCount() > 0;
        String registerHandler = "(JavirsdkVariableStateSnapshot.Builder b, Object v) -> { b.%s(%s v); }".formatted(
            firstCharLower(varHeader.getName()),
            typeAsString(varHeader)
        );
        String updateHandler = "(JavirsdkVariableStateSnapshot.Builder b, Object v) -> { b.%s(%s v); }".formatted(
            firstCharLower(varHeader.getName()),
            typeAsString(varHeader)
        );

        return "%s(%s, %s, %s, %s, %s)".formatted(
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
    private static String defaultValueAsString(IRSDKVarHeader varHeader) {
        switch (varHeader.getType()) {
            case IRSDK_CHAR -> {
                return "a";
            }
            case IRSDK_BOOL -> {
                return "false";
            }
            case IRSDK_INT, IRSDK_BITFIELD -> {
                return "0";
            }
            case IRSDK_FLOAT -> {
                return "0f";
            }
            case IRSDK_DOUBLE -> {
                return "0d";
            }
            default -> {
                return "null";
            }
        }
    }
}
