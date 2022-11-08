import java.io.*;

public class ALLCAPITALS_03 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(".idea/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt"));

        PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));

        br.lines().forEach(l -> pw.println(l.toUpperCase()));

        br.close();
        pw.close();
    }
}
