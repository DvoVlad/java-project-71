package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

public class DifferTest {
    @Test
    public void testDifferJsonStylish() throws Exception {
        String path1 = Paths.get("src", "test", "resources", "file1.json").toString();
        String path2 = Paths.get("src", "test", "resources", "file2.json").toString();
        Path expectedFilePath = Paths.get("src", "test", "resources", "expected_output.txt");
        String expected = Files.readString(expectedFilePath, StandardCharsets.UTF_8);
        String actual = Differ.generate(path1, path2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void testDifferJsonNestedStylish() throws Exception {
        String path1 = Paths.get("src", "test", "resources", "file1nested.json").toString();
        String path2 = Paths.get("src", "test", "resources", "file2nested.json").toString();
        Path expectedFilePath = Paths.get("src", "test", "resources", "expected_output_nested.txt");
        String expected = Files.readString(expectedFilePath, StandardCharsets.UTF_8);
        String actual = Differ.generate(path1, path2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void testDifferJsonPlain() throws Exception {
        String path1 = Paths.get("src", "test", "resources", "file1.json").toString();
        String path2 = Paths.get("src", "test", "resources", "file2.json").toString();
        Path expectedFilePath = Paths.get("src", "test", "resources", "expected_output_plain.txt");
        String expected = Files.readString(expectedFilePath, StandardCharsets.UTF_8);
        String actual = Differ.generate(path1, path2, "plain");
        assertEquals(expected, actual);
    }

    @Test
    public void testDifferJsonNestedPlain() throws Exception {
        String path1 = Paths.get("src", "test", "resources", "file1nested.json").toString();
        String path2 = Paths.get("src", "test", "resources", "file2nested.json").toString();
        Path expectedFilePath =
                Paths.get("src", "test", "resources", "expected_output_plain_nested.txt");
        String expected = Files.readString(expectedFilePath, StandardCharsets.UTF_8);
        String actual = Differ.generate(path1, path2, "plain");
        assertEquals(expected, actual);
    }

    @Test
    public void testDifferJsonToJson() throws Exception {
        String path1 = Paths.get("src", "test", "resources", "file1.json").toString();
        String path2 = Paths.get("src", "test", "resources", "file2.json").toString();
        Path expectedFilePath = Paths.get("src", "test", "resources", "expected_output_json.txt");
        String expected = Files.readString(expectedFilePath, StandardCharsets.UTF_8);
        String actual = Differ.generate(path1, path2, "json");
        assertEquals(expected, actual);
    }

    @Test
    public void testDifferJsonNestedToJson() throws Exception {
        String path1 = Paths.get("src", "test", "resources", "file1nested.json").toString();
        String path2 = Paths.get("src", "test", "resources", "file2nested.json").toString();
        Path expectedFilePath =
                Paths.get("src", "test", "resources", "expected_output_json_nested.txt");
        String expected = Files.readString(expectedFilePath, StandardCharsets.UTF_8);
        String actual = Differ.generate(path1, path2, "json");
        assertEquals(expected, actual);
    }

    @Test
    public void testDifferYamlStylish() throws Exception {
        String path1 = Paths.get("src", "test", "resources", "file1.yaml").toString();
        String path2 = Paths.get("src", "test", "resources", "file2.yaml").toString();
        Path expectedFilePath = Paths.get("src", "test", "resources", "expected_output.txt");
        String expected = Files.readString(expectedFilePath, StandardCharsets.UTF_8);
        String actual = Differ.generate(path1, path2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void testDifferYamlNestedStylish() throws Exception {
        String path1 = Paths.get("src", "test", "resources", "file1nested.yaml").toString();
        String path2 = Paths.get("src", "test", "resources", "file2nested.yaml").toString();
        Path expectedFilePath = Paths.get("src", "test", "resources", "expected_output_nested.txt");
        String expected = Files.readString(expectedFilePath, StandardCharsets.UTF_8);
        String actual = Differ.generate(path1, path2, "stylish");
        assertEquals(expected, actual);
    }

    @Test
    public void testDifferYamlPlain() throws Exception {
        String path1 = Paths.get("src", "test", "resources", "file1.yaml").toString();
        String path2 = Paths.get("src", "test", "resources", "file2.yaml").toString();
        Path expectedFilePath = Paths.get("src", "test", "resources", "expected_output_plain.txt");
        String expected = Files.readString(expectedFilePath, StandardCharsets.UTF_8);
        String actual = Differ.generate(path1, path2, "plain");
        assertEquals(expected, actual);
    }

    @Test
    public void testDifferYamlNestedPlain() throws Exception {
        String path1 = Paths.get("src", "test", "resources", "file1nested.yaml").toString();
        String path2 = Paths.get("src", "test", "resources", "file2nested.yaml").toString();
        Path expectedFilePath =
                Paths.get("src", "test", "resources", "expected_output_plain_nested.txt");
        String expected = Files.readString(expectedFilePath, StandardCharsets.UTF_8);
        String actual = Differ.generate(path1, path2, "plain");
        assertEquals(expected, actual);
    }

    @Test
    public void testDifferYamlToJson() throws Exception {
        String path1 = Paths.get("src", "test", "resources", "file1.yaml").toString();
        String path2 = Paths.get("src", "test", "resources", "file2.yaml").toString();
        Path expectedFilePath = Paths.get("src", "test", "resources", "expected_output_json.txt");
        String expected = Files.readString(expectedFilePath, StandardCharsets.UTF_8);
        String actual = Differ.generate(path1, path2, "json");
        assertEquals(expected, actual);
    }

    @Test
    public void testDifferYamlNestedToJson() throws Exception {
        String path1 = Paths.get("src", "test", "resources", "file1nested.yaml").toString();
        String path2 = Paths.get("src", "test", "resources", "file2nested.yaml").toString();
        Path expectedFilePath =
                Paths.get("src", "test", "resources", "expected_output_json_nested.txt");
        String expected = Files.readString(expectedFilePath, StandardCharsets.UTF_8);
        String actual = Differ.generate(path1, path2, "json");
        assertEquals(expected, actual);
    }

    @Test
    public void testDefault() throws Exception {
        String path1 = Paths.get("src", "test", "resources", "file1.json").toString();
        String path2 = Paths.get("src", "test", "resources", "file2.json").toString();
        Path expectedFilePath = Paths.get("src", "test", "resources", "expected_output.txt");
        String expected = Files.readString(expectedFilePath, StandardCharsets.UTF_8);
        String actual = Differ.generate(path1, path2);
        assertEquals(expected, actual);
    }
}
