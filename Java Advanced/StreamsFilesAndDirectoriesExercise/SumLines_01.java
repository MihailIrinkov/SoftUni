import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumLines_01 {
    public static void main(String[] args) throws IOException {

        FileReader input = new FileReader(".idea/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt");

        BufferedReader bufferedReader = new BufferedReader(input);

        String line = bufferedReader.readLine();

        while (line != null) {

            long sum = 0;

            char[] chars = line.toCharArray();

            for (char c : chars) {
                sum += c;
            }

            line = bufferedReader.readLine();
            System.out.println(sum);
        }

        bufferedReader.close();
    }
}
