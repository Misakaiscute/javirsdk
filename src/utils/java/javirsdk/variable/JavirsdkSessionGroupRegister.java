package javirsdk.variable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class JavirsdkSessionGroupRegister extends JavirsdkSessionUtils {
    private static String produceGroupTemplate(String filename) {
        String contents = """
            package javirsdk.variable.session;

            import com.fasterxml.jackson.annotation.*;

            public class %s {
                """ + appendMarker + """ 
            }
        """;
        return contents.formatted(filename);
    }
    
    public static void main(String[] args) {
        String rootGroup;
        String groupToRegister;

        if (args.length <= 1 || args.length >= 4) {
            System.out.println("This command takes 1-2 arguments");
            return;
        } else if (args.length == 2) {
            rootGroup = "SessionRoot";
            groupToRegister = args[1];
        } else {
            rootGroup = args[2];
            groupToRegister = args[1];
        } 

        try {
            //Create the new group's class
            registerGroup(groupToRegister);
            //Append the root with the new group's backing field, Json annotation and getter
            appendRootGroup(rootGroup, groupToRegister); 
        } catch (IOException e) {
            System.out.printf("No session root definition found with name %s", rootGroup);
            return;
        }
    }
    private static void appendRootGroup(String rootGroupName, String groupToRegisterName) throws IOException {
        Path rootGroupPath = Path.of("src/main/java/javirsdk/variable/session/" + rootGroupName + ".java");
        var split = Files
            .readString(rootGroupPath)
            .split(appendMarker);
        String newContents = new StringBuilder()
            .append(split[0])
            .append(produceGroupItemTemplate(groupToRegisterName, groupToRegisterName, "null"))
            .append(split[1])
            .toString();
        Files.writeString(rootGroupPath, newContents);
    }
    private static void registerGroup(String groupToRegisterName) throws IOException {
        Path path = Path.of("src/main/java/javirsdk/variable/session/" + groupToRegisterName + ".java");
        Files.createFile(path);
        Files.writeString(path, produceGroupTemplate(groupToRegisterName));
    } 
}
