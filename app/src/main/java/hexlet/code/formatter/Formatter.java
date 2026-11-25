package hexlet.code.formatter;

import hexlet.code.App;
import java.util.Map;
import java.util.TreeMap;
import picocli.CommandLine;

public class Formatter {
    @CommandLine.Command()
    public static void format(
            TreeMap<String, Object> map, Map<String, Object> map1, Map<String, Object> map2) {
        if (App.format.equals("stylish")) {
            StylishFormatter.format(map, map1, map2);
        }
        ;
    }
}
