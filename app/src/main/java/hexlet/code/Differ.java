package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Files;
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
        Map<String, Object> result = new TreeMap<>();
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
        System.out.println("{");
        for (var resultPaint : result.entrySet()) {
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
        // System.out.println(result);
        // System.out.println(map1);
        // System.out.println(map2);
    }

    public static Map<String, Object> parse(Path path) throws Exception {
        String content = Files.readString(path);

        if (Files.probeContentType(path).equals("application/json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(content, new TypeReference<Map<String, Object>>() {});
        }
        return Map.of();
    }
}
