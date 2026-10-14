package javirsdk.variable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class JavirsdkSessionVariableRegister extends JavirsdkSessionUtils {
    public static void main(String[] args) {
        String varName;
        String varType;
        String groupName;

        if (args.length != 4) {
            System.out.println("This command takes exactly 3 arguments");
            return;
        } else {
            varName = args[1];
            varType = args[2];
            groupName = args[3];
        } 
        
        try {
            appendGroup(groupName, varName, varType);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Unable to find root %s".formatted(groupName));
        }
        
    }
    private static void appendGroup(String groupName, String varName, String varType) throws IllegalArgumentException, IOException {
        Path rootGroupPath = Path.of("src/main/java/javirsdk/variable/session/" + groupName + ".java");
        var split = Files
            .readString(rootGroupPath)
            .split(appendMarker);
        String defaultVal = defaultAsString(varType);
        String newContents = new StringBuilder()
            .append(split[0])
            .append(produceGroupItemTemplate(varName, varType, defaultVal))
            .append(split[1])
            .toString();
        Files.writeString(rootGroupPath, newContents);
    }
    private static String defaultAsString(String type) throws IllegalArgumentException {
        switch (type) {
            case "Character", "char" -> {
                return "a";
            }
            case "Boolean", "boolean"-> {
                return "False";
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
