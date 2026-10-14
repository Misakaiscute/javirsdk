package javirsdk.variable;

public class JavirsdkSessionUtils {
    protected static final String appendMarker = "//$...";
    protected static String firstCharLower(String str) {
        char[] strArr = str.toCharArray();
        strArr[0] = Character.toLowerCase(strArr[0]);

        return new String(strArr);
    }
    protected static String produceGroupItemTemplate(String varName, String type, String def) {
        String backingFieldVarName = firstCharLower(varName);
        String jsonProperty = "@JsonProperty(\"%s\")"
            .formatted(varName);
        String backingField = "private %s %s = %s"
            .formatted(type, backingFieldVarName, def);
        String getter = "public %s get%s() { return %s; }"
            .formatted(type, varName, backingFieldVarName);

        String contents = new StringBuilder()
            .append(jsonProperty).append('\n')
            .append(backingField).append('\n')
            .append(getter).append('\n')
            .append(appendMarker).append('\n')
            .toString();

        return contents;
    }
}
