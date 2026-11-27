package hexlet.code.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import org.apache.tika.Tika;

public class Parser {
    public static Map<String, Object> parse(Path path) throws Exception {
        String content = Files.readString(path);
        Tika tika = new Tika();
        return switch (tika.detect(path)) {
            case "application/json" -> JsonParser.parse(content);
            case "text/x-yaml" -> YamlParser.parse(content);
            default -> throw new Exception("Unsupported file format " + tika.detect(path));
        };
    }
}
