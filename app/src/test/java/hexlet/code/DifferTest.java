package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DifferTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor, true, StandardCharsets.UTF_8));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testDifferJson() {
        String path1 = Paths.get("src", "test", "resources", "file1.json").toString();
        String path2 = Paths.get("src", "test", "resources", "file2.json").toString();
        Path expectedFilePath = Paths.get("src", "test", "resources", "expected_output.txt");
        try {
            Differ.generate(path1, path2);
            String expected = Files.readString(expectedFilePath, StandardCharsets.UTF_8);
            String actual = outputStreamCaptor.toString(StandardCharsets.UTF_8);
            assertEquals(expected, actual);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
