import java.io.*;

public class WriteEveryThirdLine_05 {
    public static void main(String[] args) throws IOException {

        String path = ".idea/resources/input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        FileOutputStream outputStream = new FileOutputStream("every-third-line.txt");
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));

        int counter = 1;

        String line = reader.readLine();

        while (line != null) {

            if (counter % 3 == 0) {
                writer.write(line);
                writer.newLine();
            }

            counter++;

            line = reader.readLine();
        }

        reader.close();
        writer.flush();
        writer.close();
    }
}
