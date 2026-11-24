package hexlet.code.utils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import org.apache.tika.Tika;

public class Parser {
    public static Map<String, Object> parse(Path path) throws Exception {
        String content = Files.readString(path);
        Tika tika = new Tika();
        if (tika.detect(path).equals("application/json")) {
            return parseJson(content);
        }
        if (tika.detect(path).equals("text/x-yaml")) {
            return parseYaml(content);
        }
        return Map.of();
    }

    private static Map<String, Object> parseJson(String content) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, new TypeReference<Map<String, Object>>() {});
    }

    private static Map<String, Object> parseYaml(String content) throws Exception {
        ObjectMapper objectMapper = new YAMLMapper();
        return objectMapper.readValue(content, new TypeReference<Map<String, Object>>() {});
    }
}
