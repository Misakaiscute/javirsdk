package javirsdk.variable;

import java.nio.file.Path;

public class JavirsdkSessionUtils {
    protected static Path basePath = Path.of("src/main/java/javirsdk/variable/session/");
    protected static final String appendMarker = "//$...";
    protected static String firstCharLower(String str) {
        char[] strArr = str.toCharArray();
        strArr[0] = Character.toLowerCase(strArr[0]);

        return new String(strArr);
    }
    protected static String produceGroupItemTemplate(String varYamlName, String varName, String type, String def) {
        String backingFieldVarName = firstCharLower(varName);
        String jsonProperty = "@JsonProperty(\"%s\")"
            .formatted(varYamlName);
        String backingField = "\t\tprivate %s %s = %s;"
            .formatted(type, backingFieldVarName, def);
        String getter = "\t\tpublic %s get%s() { return %s; }"
            .formatted(type, varName, backingFieldVarName);

        String contents = new StringBuilder()
            .append(jsonProperty).append('\n')
            .append(backingField).append('\n')
            .append(getter).append('\n')
            .append("\t\t").append(appendMarker)
            .toString();

        return contents;
    }
}
