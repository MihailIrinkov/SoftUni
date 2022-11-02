import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadFile_01 {
    public static void main(String[] args) {

        String path = "C:\\Users\\HP\\Desktop\\Java Advanced\\IntelliJ\\StreamsFilesDirectoriesLab\\.idea\\resources\\input.txt";


                try {
                    FileInputStream fileInputStream = new FileInputStream(path);

                    int bytes = fileInputStream.read();

                    while (bytes != -1) {

                            System.out.print(Integer.toBinaryString(bytes) + " ");


                        bytes = fileInputStream.read();
                    }
                } catch (IOException e) {
                }

    }
}
