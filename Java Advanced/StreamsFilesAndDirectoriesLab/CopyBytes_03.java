import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes_03 {
    public static void main(String[] args) throws IOException {

        String path = ".idea/resources/input.txt";

        FileInputStream inputStream = new FileInputStream(path);
        FileOutputStream outputStream = new FileOutputStream("output_02.txt");

        int bytes = inputStream.read();

        while (bytes != -1) {


            if ((char)bytes == ' ' || (char)bytes == '\n') {
                outputStream.write(bytes);
            } else {

                String digits = String.valueOf(bytes);

                for (int i = 0; i < digits.length(); i++) {
                    outputStream.write(digits.charAt(i));

                }
            }

            bytes = inputStream.read();
        }

        inputStream.close();
        outputStream.close();

    }
}
