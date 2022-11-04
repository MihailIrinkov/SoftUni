import java.io.File;
import java.nio.file.Files;

public class ListFiles_07 {
    public static void main(String[] args) {

        File file = new File(".idea/resources/Files-and-Streams");

        if(file.isDirectory()){
            File[] files = file.listFiles();

            for (File f : files) {
                if(f.isFile()){
                    System.out.printf("%s: [%d]%n", f.getName(), f.length());
                }

            }
        }

    }
}
