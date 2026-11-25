package hexlet.code.formatters;

import java.util.Map;
import java.util.TreeMap;

public class StylishFormatter {
    public static String format(
            TreeMap<String, Object> map, Map<String, Object> map1, Map<String, Object> map2) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (var resultPaint : map.entrySet()) {
            var key = resultPaint.getKey();
            var value = resultPaint.getValue();
            if (value.equals("deleted")) {
                sb.append("  - ").append(key).append(": ").append(map1.get(key)).append("\n");
            } else if (value.equals("unchanged")) {
                sb.append("    ").append(key).append(": ").append(map1.get(key)).append("\n");
            } else if (value.equals("changed")) {
                sb.append("  - ").append(key).append(": ").append(map1.get(key)).append("\n");
                sb.append("  + ").append(key).append(": ").append(map2.get(key)).append("\n");
            } else if (value.equals("added")) {
                sb.append("  + ").append(key).append(": ").append(map2.get(key)).append("\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }
}
