package javirsdk.variable;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public final class JavirsdkSessionGroupRegister extends JavirsdkSessionUtils {
    private static String rootGroup;
    private static boolean appendRoot;
    private static String groupName;
    private static String groupYamlName;

    private static String nullGroup = "SessionRoot";
    
    public static void main(String[] args) {
        if (args.length <= 2 || args.length >= 5) {
            System.out.println("This command takes 3-4 arguments");
            return;
        } else {
            rootGroup= args[0];
            appendRoot = args[1] == "0" ? false : true;
            groupName = args[2];
            if (args.length == 4) {
                groupYamlName = args[3];
            } else {
                groupYamlName = groupName;
            }
        }

        try {
            //Create the new group's class
            registerGroup();
            //Append the root with the new group's backing field, Json annotation and getter
            if (appendRoot) {
                appendRootGroup(); 
            }
        } catch (IOException e) {
            System.out.printf("No session root definition found with name %s", rootGroup);
            return;
        }
    }
    private static void appendRootGroup() throws IOException {
        String rootGroupName = rootGroup == null ? nullGroup : rootGroup;

        Path path = basePath.resolve(rootGroupName + ".java");
        var split = Files
            .readString(path)
            .split(Pattern.quote(appendMarker));
        String newContents = new StringBuilder()
            .append(split[0])
            .append(produceGroupItemTemplate(groupYamlName, groupName, groupName, "null"))
            .append(split[1])
            .toString();
        Files.writeString(path, newContents);
    }
    private static void registerGroup() throws IOException {
        Path path = basePath.resolve(groupName + ".java");
        if (!Files.exists(path)){
            Files.createFile(path);
            Files.writeString(path, produceGroupTemplate(groupName));
        }
    }
    private static String produceGroupTemplate(String filename) {
        String contents = """
            package javirsdk.variable.session;

            import com.fasterxml.jackson.annotation.*;

            public class %s {
                \t""" + appendMarker + """ 
            \n}
        """;
        return contents.formatted(filename);
    } 
}
