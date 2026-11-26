package hexlet.code.formatters;

import java.util.List;
import java.util.TreeMap;

public class StylishFormatter {
    public static String format(TreeMap<String, List<Object>> diff) {
        StringBuilder sb = new StringBuilder();
        sb.append("{").append(System.lineSeparator());
        for (var resultPaint : diff.entrySet()) {
            var key = resultPaint.getKey();
            var value = resultPaint.getValue();
            switch ((String) value.get(0)) {
                case "deleted" ->
                        sb.append(" ".repeat(2))
                                .append("- ")
                                .append(key)
                                .append(": ")
                                .append(value.get(1))
                                .append(System.lineSeparator());
                case "unchanged" ->
                        sb.append(" ".repeat(4))
                                .append(key)
                                .append(": ")
                                .append(value.get(1))
                                .append(System.lineSeparator());
                case "changed" -> {
                    sb.append(" ".repeat(2))
                            .append("- ")
                            .append(key)
                            .append(": ")
                            .append(value.get(1))
                            .append(System.lineSeparator());
                    sb.append(" ".repeat(2))
                            .append("+ ")
                            .append(key)
                            .append(": ")
                            .append(value.get(2))
                            .append(System.lineSeparator());
                }
                case "added" ->
                        sb.append(" ".repeat(2))
                                .append("+ ")
                                .append(key)
                                .append(": ")
                                .append(value.get(1))
                                .append(System.lineSeparator());
            }
        }
        sb.append("}").append(System.lineSeparator());
        return sb.toString();
    }
}
