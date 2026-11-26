package hexlet.code.formatters;

import java.util.List;
import java.util.TreeMap;

public class Formatter {
    public static String format(TreeMap<String, List<Object>> diff, String formatName)
            throws Exception {
        if (formatName.equals("stylish")) {
            return StylishFormatter.format(diff);
        } else if (formatName.equals("plain")) {
            return PlainFormatter.format(diff);
        } else if (formatName.equals("json")) {
            return JsonFormatter.format(diff);
        }
        throw new Exception("Формат " + formatName + " не опознан");
    }
}
