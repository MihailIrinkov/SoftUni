import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines_06 {
    public static void main(String[] args) throws IOException {

        String pathIn = ".idea/resources/input.txt";
        String pathOut = "sorted.txt";

        Path inPath = Paths.get(pathIn);
        Path outPath = Paths.get(pathOut);
        List<String> lines = Files.readAllLines(inPath);
        Collections.sort(lines);

        Files.write(outPath, lines);

    }
}
