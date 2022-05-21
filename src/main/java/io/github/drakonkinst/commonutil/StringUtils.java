package io.github.drakonkinst.commonutil;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils {
    private StringUtils() {}

    // https://stackoverflow.com/questions/7661460/replace-multiple-substrings-at-once
    public static String replaceEach(Map<String, String> replacements, String input) {
        // Create the pattern joining the keys with '|'
        String regexp = String.join("|", replacements.keySet());

        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(input);

        while (m.find())
            m.appendReplacement(sb, replacements.get(m.group()));
        m.appendTail(sb);
        return sb.toString();
    }
    public static String snakeToCamel(String s) {
        String[] parts = s.split("_");
        String camelCaseString = parts[0];
        for (int i = 1; i < parts.length; ++i) {
            camelCaseString = camelCaseString + toProperCase(parts[i]);
        }
        return camelCaseString;
    }

    private static String toProperCase(String s) {
        return s.substring(0, 1).toUpperCase() +
                s.substring(1);
    }
}
