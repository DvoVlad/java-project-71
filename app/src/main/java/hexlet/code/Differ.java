package hexlet.code;

import static hexlet.code.utils.Parser.parse;

import hexlet.code.formatter.Formatter;
import java.nio.file.Path;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Differ {
    public static void generate(String filepath1, String filepath2) throws Exception {
        Path path1 = Path.of(filepath1);
        Path path2 = Path.of(filepath2);
        Map<String, Object> map1 = parse(path1);
        Map<String, Object> map2 = parse(path2);
        TreeMap<String, Object> result = new TreeMap<>();
        for (var pair : map1.entrySet()) {
            var key = pair.getKey();
            var value = pair.getValue();
            if (Objects.equals(map2.get(key), value)) {
                result.put(key, "unchanged");
            } else if (!map2.containsKey(key)) {
                result.put(key, "deleted");
            } else if (!Objects.equals(map2.get(key), value)) {
                result.put(key, "changed");
            }
        }
        for (var key2 : map2.keySet()) {
            if (!map1.containsKey(key2)) {
                result.put(key2, "added");
            }
        }
        Formatter.format(result, map1, map2);
    }
}
