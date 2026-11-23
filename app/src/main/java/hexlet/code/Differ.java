package hexlet.code;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Path;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class Differ {
    public static void generate(String filepath1, String filepath2) throws Exception {
        Path path1 = Path.of(filepath1);
        Path path2 = Path.of(filepath2);
        Map<String, Object> map1 = parse(path1);
        Map<String, Object> map2 = parse(path2);
        System.out.println(map1);
        System.out.println(map2);
    }

    public static Map<String, Object> parse(Path path) throws Exception {
        String content = Files.readString(path);

        if(Files.probeContentType(path).equals("application/json")) {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(content, new TypeReference<Map<String, Object>>() {
            });
        }
        return Map.of();
    }
}
