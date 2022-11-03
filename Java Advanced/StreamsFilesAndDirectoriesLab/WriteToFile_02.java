import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;

public class WriteToFile_02 {
    public static void main(String[] args) throws IOException {

        String path = ".idea/resources/input.txt";

        FileOutputStream outputStream = new FileOutputStream("output.txt");

        Set<Character> punctuationTable = Set.of(',', '.', '!', '?');

        FileInputStream inputStream = new FileInputStream(path);

        int bytes = inputStream.read();


        while (bytes != -1) {

            char symbol = (char) bytes;

            boolean isPunctuation = punctuationTable.contains(symbol);

            if(!isPunctuation) {
                outputStream.write(symbol);
               // System.out.print(symbol);
            }
            bytes = inputStream.read();
        }

    }
}
