import java.util.Scanner;

public class Bee_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i] = scanner.nextLine().toCharArray();
        }

        int rowB = -1;
        int colB = -1;

        int flowersCount = 0;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (matrix[r][c] == 'B') {
                    rowB = r;
                    colB = c;
                }
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            matrix[rowB][colB] = '.';

            if (command.equals("up") && (rowB - 1) >= 0) {
                rowB--;
            } else if (command.equals("down") && (rowB + 1) < matrix.length) {
                rowB++;
            } else if (command.equals("left") && (colB - 1) >= 0) {
                colB--;
            } else if (command.equals("right") && (colB + 1) < matrix.length) {
                colB++;
            } else {
                System.out.println("The bee got lost!");
                break;
            }

            if (matrix[rowB][colB] == 'O') {
                continue;
            } else if (matrix[rowB][colB] == 'f') {
                flowersCount++;
            }

            matrix[rowB][colB] = 'B';

            command = scanner.nextLine();
        }

        if (flowersCount < 5) {
            System.out.printf
                    ("The bee couldn't pollinate the flowers, she needed %d flowers more%n"
                            , (5 - flowersCount));
            printMatrix(matrix);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n"
                    , flowersCount);
            printMatrix(matrix);
        }

    }

    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
