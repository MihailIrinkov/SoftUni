import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPicture_09 {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream(".idea/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/BMW-X5.jpg");
        FileOutputStream fos = new FileOutputStream(".idea/resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/BMW-X5-Copy.jpg");

        byte[] buffer = new byte[1024];

        while (fis.read(buffer) >= 0) {

            fos.write(buffer);
        }
        fis.close();
        fos.close();
    }
}
