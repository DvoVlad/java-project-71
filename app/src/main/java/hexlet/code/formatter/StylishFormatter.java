package hexlet.code.formatter;

import java.util.Map;
import java.util.TreeMap;

public class StylishFormatter {
    public static void format(
            TreeMap<String, Object> map, Map<String, Object> map1, Map<String, Object> map2) {
        System.out.println("{");
        for (var resultPaint : map.entrySet()) {
            var key = resultPaint.getKey();
            var value = resultPaint.getValue();
            if (value.equals("deleted")) {
                System.out.println("  - " + key + ": " + map1.get(key));
            } else if (value.equals("unchanged")) {
                System.out.println("    " + key + ": " + map1.get(key));
            } else if (value.equals("changed")) {
                System.out.println("  - " + key + ": " + map1.get(key));
                System.out.println("  + " + key + ": " + map2.get(key));
            } else if (value.equals("added")) {
                System.out.println("  + " + key + ": " + map2.get(key));
            }
        }
        System.out.println("}");
    }
}
