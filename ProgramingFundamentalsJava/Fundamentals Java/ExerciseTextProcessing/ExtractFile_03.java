import java.util.Scanner;

public class ExtractFile_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] filePath = input.split("\\\\");

        String fullFileName = filePath[filePath.length - 1];

        String fileName = fullFileName.split("\\.")[0];
        String fileExtension = fullFileName.split("\\.")[1];

        System.out.printf("File name: %s%n", fileName);
        System.out.printf("File extension: %s", fileExtension);
    }
}
