package hexlet.code;

import static hexlet.code.utils.Parser.parse;

import hexlet.code.formatters.Formatter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Differ {
    public static String generate(String filepath1, String filepath2, String formatName)
            throws Exception {
        Path path1 = Path.of(filepath1);
        Path path2 = Path.of(filepath2);
        Map<String, Object> map1 = parse(path1);
        Map<String, Object> map2 = parse(path2);
        TreeMap<String, List<Object>> result = computeDifference(map1, map2);

        return Formatter.format(result, formatName);
    }

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static TreeMap<String, List<Object>> computeDifference(
            Map<String, Object> map1, Map<String, Object> map2) {
        TreeMap<String, List<Object>> result = new TreeMap<>();
        for (var pair : map1.entrySet()) {
            var key = pair.getKey();
            var value = pair.getValue();
            if (Objects.equals(map2.get(key), value)) {
                List<Object> list = new ArrayList<>();
                list.add("unchanged");
                list.add(value);
                result.put(key, list);
            } else if (!map2.containsKey(key)) {
                List<Object> list = new ArrayList<>();
                list.add("deleted");
                list.add(value);
                result.put(key, list);
            } else if (!Objects.equals(map2.get(key), value)) {
                List<Object> list = new ArrayList<>();
                list.add("changed");
                list.add(value);
                list.add(map2.get(key));
                result.put(key, list);
            }
        }
        for (var key2 : map2.keySet()) {
            if (!map1.containsKey(key2)) {
                List<Object> list = new ArrayList<>();
                list.add("added");
                list.add(map2.get(key2));
                result.put(key2, list);
            }
        }
        return result;
    }
}
