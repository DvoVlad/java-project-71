package hexlet.code.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import org.apache.tika.Tika;

public class Parser {
    public static Map<String, Object> parse(Path path)
            throws IOException, JsonMappingException, Exception {
        String content = Files.readString(path);
        Tika tika = new Tika();
        if (tika.detect(path).equals("application/json")) {
            return parseJson(content);
        }
        if (tika.detect(path).equals("text/x-yaml")) {
            return parseYaml(content);
        }
        throw new Exception("Unsupported file format " + tika.detect(path));
    }

    private static Map<String, Object> parseJson(String content)
            throws JsonMappingException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(content, new TypeReference<Map<String, Object>>() {});
    }

    private static Map<String, Object> parseYaml(String content)
            throws JsonMappingException, JsonProcessingException {
        ObjectMapper objectMapper = new YAMLMapper();
        return objectMapper.readValue(content, new TypeReference<Map<String, Object>>() {});
    }
}
