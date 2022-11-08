import java.io.*;

public class LineNumbers_05 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(".idea/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt"));

        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

        String line = br.readLine();

        int counter = 1;

        while (line != null) {

            pw.println(counter + ". " + line);

            counter++;
            line = br.readLine();
        }

        br.close();
        pw.close();

    }
}
