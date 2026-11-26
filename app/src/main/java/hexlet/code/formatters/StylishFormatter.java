package hexlet.code.formatters;

import java.util.Map;
import java.util.TreeMap;

public class StylishFormatter {
    public static String format(
            TreeMap<String, String> map, Map<String, Object> map1, Map<String, Object> map2) {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append(System.lineSeparator());
        for (var resultPaint : map.entrySet()) {
            var key = resultPaint.getKey();
            var value = resultPaint.getValue();
            switch (value) {
                case "deleted" ->
                        sb.append(" ".repeat(2))
                                .append("- ")
                                .append(key)
                                .append(": ")
                                .append(map1.get(key))
                                .append(System.lineSeparator());
                case "unchanged" ->
                        sb.append(" ".repeat(4))
                                .append(key)
                                .append(": ")
                                .append(map1.get(key))
                                .append(System.lineSeparator());
                case "changed" -> {
                    sb.append(" ".repeat(2))
                            .append("- ")
                            .append(key)
                            .append(": ")
                            .append(map1.get(key))
                            .append(System.lineSeparator());
                    sb.append(" ".repeat(2))
                            .append("+ ")
                            .append(key)
                            .append(": ")
                            .append(map2.get(key))
                            .append(System.lineSeparator());
                }
                case "added" ->
                        sb.append(" ".repeat(2))
                                .append("+ ")
                                .append(key)
                                .append(": ")
                                .append(map2.get(key))
                                .append(System.lineSeparator());
            }
        }
        sb.append("}").append(System.lineSeparator());
        return sb.toString();
    }
}
