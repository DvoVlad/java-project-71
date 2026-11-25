package hexlet.code.formatters;

import java.util.Map;
import java.util.TreeMap;

public class Formatter {
    public static String format(
            TreeMap<String, Object> map,
            Map<String, Object> map1,
            Map<String, Object> map2,
            String formatName)
            throws Exception {
        if (formatName.equals("stylish")) {
            return StylishFormatter.format(map, map1, map2);
        } else if (formatName.equals("plain")) {
            return PlainFormatter.format(map, map1, map2);
        }
        throw new Exception("Формат не опознан");
    }
}
