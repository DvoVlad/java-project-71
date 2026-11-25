package hexlet.code.formatters;

import java.util.Map;
import java.util.TreeMap;

public class StylishFormatter {
    public static String format(
            TreeMap<String, String> map, Map<String, Object> map1, Map<String, Object> map2) {
        StringBuilder sb = new StringBuilder();
        sb.append("{\n");
        for (var resultPaint : map.entrySet()) {
            var key = resultPaint.getKey();
            var value = resultPaint.getValue();
            switch (value) {
                case "deleted" ->
                        sb.append("  - ")
                                .append(key)
                                .append(": ")
                                .append(map1.get(key))
                                .append("\n");
                case "unchanged" ->
                        sb.append("    ")
                                .append(key)
                                .append(": ")
                                .append(map1.get(key))
                                .append("\n");
                case "changed" -> {
                    sb.append("  - ").append(key).append(": ").append(map1.get(key)).append("\n");
                    sb.append("  + ").append(key).append(": ").append(map2.get(key)).append("\n");
                }
                case "added" ->
                        sb.append("  + ")
                                .append(key)
                                .append(": ")
                                .append(map2.get(key))
                                .append("\n");
            }
        }
        sb.append("}\n");
        return sb.toString();
    }
}
