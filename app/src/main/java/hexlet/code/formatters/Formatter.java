package hexlet.code.formatters;

import java.util.List;
import java.util.TreeMap;

public class Formatter {
    public static String format(TreeMap<String, List<Object>> diff, String formatName)
            throws Exception {
        return switch (formatName) {
            case "stylish" -> StylishFormatter.format(diff);
            case "plain" -> PlainFormatter.format(diff);
            case "json" -> JsonFormatter.format(diff);
            default -> throw new Exception("Формат " + formatName + " не опознан");
        };
    }
}
