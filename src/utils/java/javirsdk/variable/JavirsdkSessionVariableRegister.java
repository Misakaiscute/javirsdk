package javirsdk.variable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public final class JavirsdkSessionVariableRegister extends JavirsdkSessionUtils {
    private static String groupName;
    private static String varType;
    private static String varName;
    private static String varYamlName;

    public static void main(String[] args) {
        if (args.length <= 0 || args.length >= 5) {
            System.out.println("This command takes 3-4 arguments");
            return;
        } else {
            groupName = args[0];
            varType = args[1];
            varName = args[2];
            if (args.length == 4) {
                varYamlName = args[3];
            } else {
                varYamlName = varName;
            }
        }
        
        try {
            appendGroup();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Unable to find root %s".formatted(groupName));
        }
    }
    private static void appendGroup() throws IllegalArgumentException, IOException {
        Path rootGroupPath = Path.of("src/main/java/javirsdk/variable/session/" + groupName + ".java");
        var split = Files
            .readString(rootGroupPath)
            .split(Pattern.quote(appendMarker));

        String defaultVal = defaultAsString(varType);

        String newContents = new StringBuilder()
            .append(split[0])
            .append(produceGroupItemTemplate(varYamlName, varName, varType, defaultVal))
            .append(split[1])
            .toString();
        Files.writeString(rootGroupPath, newContents);
    }
    private static String defaultAsString(String type) throws IllegalArgumentException {
        if (type.contains("[]")) {
            return null;
        }
        switch (type) {
            case "Character", "char" -> {
                return "a";
            }
            case "String" -> {
                return null;
            }
            case "Boolean", "boolean"-> {
                return "false";
            }
            case "Integer", "int" -> {
                return "0";
            }
            case "Float", "float" -> {
                return "0f";
            }
            case "Double", "double" -> {
                return "0.0";
            }
            default -> {
                throw new IllegalArgumentException("Type %s is invalid.".formatted(type));
            }
        }
    }
}
