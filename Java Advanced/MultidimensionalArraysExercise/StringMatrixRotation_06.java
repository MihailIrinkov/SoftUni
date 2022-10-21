import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] ratationInput = scanner.nextLine().split("[()]");
        int rotatingDegree = Integer.parseInt(ratationInput[1]) % 360;

        String input = scanner.nextLine();

        int cols = Integer.MIN_VALUE;
        int rows = 0;

        List<String> list = new ArrayList<>();

        while (!input.equals("END")) {
            if (input.length() > cols) {
                cols = input.length();
            }
            list.add(input);

            rows++;
            input = scanner.nextLine();
        }

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String currentString = list.get(row);

                if (col <= currentString.length() - 1) {
                    matrix[row][col] = currentString.charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

        switch (rotatingDegree) {
            case 0:
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int row = rows - 1; row >= 0; row--) {
                    for (int col = cols - 1; col >= 0; col--) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0; row < rows; row++) {
                        System.out.print(matrix[row][col]);
                    }
                    System.out.println();
                }
                break;
        }
    }

}

