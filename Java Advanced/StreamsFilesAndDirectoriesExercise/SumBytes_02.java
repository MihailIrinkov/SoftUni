import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes_02 {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader(".idea/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt");

        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String input = bufferedReader.readLine();

        long sum = 0;

        while (input != null) {

            char[] chars = input.toCharArray();

            for (char c : chars) {
                sum += c;
            }

            input = bufferedReader.readLine();
        }
        System.out.println(sum);
        bufferedReader.close();
    }
}
