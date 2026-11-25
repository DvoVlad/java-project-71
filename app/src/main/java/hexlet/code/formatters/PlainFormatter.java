package hexlet.code.formatters;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class PlainFormatter {
    public static String format(
            TreeMap<String, String> map, Map<String, Object> map1, Map<String, Object> map2) {
        StringBuilder sb = new StringBuilder();
        for (var resultPaint : map.entrySet()) {
            var key = resultPaint.getKey();
            var value = resultPaint.getValue();
            if (value.equals("deleted")) {
                sb.append("Property '").append(key).append("' was removed").append("\n");
            } else if (value.equals("changed")) {
                String value1;
                String value2;
                if (map1.get(key) == null) {
                    value1 = "null";
                } else if (map1.get(key) instanceof String) {
                    value1 = "'" + map1.get(key) + "'";
                } else {
                    value1 =
                            map1.get(key) instanceof ArrayList<?>
                                            || map1.get(key) instanceof LinkedHashMap<?, ?>
                                    ? "[complex value]"
                                    : map1.get(key).toString();
                }
                if (map2.get(key) == null) {
                    value2 = "null";
                } else if (map2.get(key) instanceof String) {
                    value2 = "'" + map2.get(key) + "'";
                } else {
                    value2 =
                            map2.get(key) instanceof ArrayList<?>
                                            || map2.get(key) instanceof LinkedHashMap<?, ?>
                                    ? "[complex value]"
                                    : map2.get(key).toString();
                }
                sb.append("Property '")
                        .append(key)
                        .append("' was updated. From ")
                        .append(value1)
                        .append(" to ")
                        .append(value2)
                        .append("\n");
                ;
            } else if (value.equals("added")) {
                String valueAdded;
                if (map2.get(key) == null) {
                    valueAdded = "null";
                } else if (map2.get(key) instanceof String) {
                    valueAdded = "'" + map2.get(key) + "'";
                } else {
                    valueAdded =
                            map2.get(key) instanceof ArrayList<?>
                                            || map2.get(key) instanceof LinkedHashMap<?, ?>
                                    ? "[complex value]"
                                    : map2.get(key).toString();
                }
                sb.append("Property '")
                        .append(key)
                        .append("' was added with value: ")
                        .append(valueAdded)
                        .append("\n");
            }
        }
        return sb.toString();
    }
}
