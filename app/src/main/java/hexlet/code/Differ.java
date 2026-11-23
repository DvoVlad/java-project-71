package hexlet.code;
import java.util.Map;
import java.nio.file.Files;
import java.nio.file.Path;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public class Differ {
    public static void generate(String filepath1, String filepath2) throws Exception {
        Map<String, Object> map1 = Map.of();
        Map<String, Object> map2 = Map.of();
        Path path1 = Path.of(filepath1);
        Path path2 = Path.of(filepath2);
        String type1 = Files.probeContentType(path1);
        String type2 = Files.probeContentType(path2);
        if(type1.equals("application/json")) {
            map1 = parseJson(path1);
        }
        if(type2.equals("application/json")) {
            map2 = parseJson(path2);
        }
    }

    public static Map<String, Object> parseJson(Path path) throws Exception {
        String json = Files.readString(path);

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, new TypeReference<Map<String,Object>>(){});
    }
}
