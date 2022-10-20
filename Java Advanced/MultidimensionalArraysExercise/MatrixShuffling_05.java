import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimension = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        String[][] matrix = new String[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");

        }
        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String keyword = command.split(" ")[0];
            String[] commandLength = command.split(" ");

            if (!keyword.equals("swap") || commandLength.length != 5) {
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }

            if (command.split(" ")[1].isEmpty()) {
                System.out.println("Invalid input!");
            } else if (command.split(" ")[2].isEmpty()) {
                System.out.println("Invalid input!");
            } else if (command.split(" ")[3].isEmpty()) {
                System.out.println("Invalid input!");
            } else if (command.split(" ")[4].isEmpty()) {
                System.out.println("Invalid input!");
            }
            int row1 = Integer.parseInt(command.split(" ")[1]);
            if (row1 < 0) {
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }
            int col1 = Integer.parseInt(command.split(" ")[2]);
            if (col1 < 0) {
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }
            int row2 = Integer.parseInt(command.split(" ")[3]);
            if (row2 < 0) {
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }
            int col2 = Integer.parseInt(command.split(" ")[4]);
            if (col2 < 0) {
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            }

            if (row1 > rows || col1 > cols || row2 > rows || col2 > cols) {
                System.out.println("Invalid input!");
                command = scanner.nextLine();
                continue;
            } else {
                String currentElement1 = matrix[row1][col1];
                String currentElement2 = matrix[row2][col2];
                matrix[row1][col1] = currentElement2;
                matrix[row2][col2] = currentElement1;

                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col] + " ");
                    }
                    System.out.println();
                }
            }


            command = scanner.nextLine();
        }

    }
}

