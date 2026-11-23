package hexlet.code;

import picocli.CommandLine.Command;

@Command(name = "gendiff", mixinStandardHelpOptions = true, version = "gendiff 1.0",
        description = "Compares two configuration files and shows a difference.")
public class Differ {
    public static void generate(String filepath1, String filepath2) {

    }
}
