package hexlet.code.formatters;

import java.util.*;

public class PlainFormatter {
    public static String format(TreeMap<String, List<Object>> diff) {
        StringBuilder sb = new StringBuilder();
        String separator = System.lineSeparator();
        for (var resultPaint : diff.entrySet()) {
            var key = resultPaint.getKey();
            var value = resultPaint.getValue();
            switch ((String) value.get(0)) {
                case "deleted" ->
                        sb.append("Property '")
                                .append(key)
                                .append("' was removed")
                                .append(separator);
                case "changed" -> {
                    String value1;
                    String value2;
                    if (value.get(1) == null) {
                        value1 = "null";
                    } else if (value.get(1) instanceof String) {
                        value1 = "'" + value.get(1) + "'";
                    } else {
                        value1 =
                                value.get(1) instanceof ArrayList<?>
                                                || value.get(1) instanceof LinkedHashMap<?, ?>
                                        ? "[complex value]"
                                        : value.get(1).toString();
                    }
                    if (value.get(2) == null) {
                        value2 = "null";
                    } else if (value.get(2) instanceof String) {
                        value2 = "'" + value.get(2) + "'";
                    } else {
                        value2 =
                                value.get(2) instanceof ArrayList<?>
                                                || value.get(2) instanceof LinkedHashMap<?, ?>
                                        ? "[complex value]"
                                        : value.get(2).toString();
                    }
                    sb.append("Property '")
                            .append(key)
                            .append("' was updated. From ")
                            .append(value1)
                            .append(" to ")
                            .append(value2)
                            .append(separator);
                    ;
                }
                case "added" -> {
                    String valueAdded;
                    if (value.get(1) == null) {
                        valueAdded = "null";
                    } else if (value.get(1) instanceof String) {
                        valueAdded = "'" + value.get(1) + "'";
                    } else {
                        valueAdded =
                                value.get(1) instanceof ArrayList<?>
                                                || value.get(1) instanceof LinkedHashMap<?, ?>
                                        ? "[complex value]"
                                        : value.get(1).toString();
                    }
                    sb.append("Property '")
                            .append(key)
                            .append("' was added with value: ")
                            .append(valueAdded)
                            .append(separator);
                }
            }
        }
        if (!sb.isEmpty()) {
            sb.setLength(sb.length() - separator.length());
        }
        return sb.toString();
    }
}
