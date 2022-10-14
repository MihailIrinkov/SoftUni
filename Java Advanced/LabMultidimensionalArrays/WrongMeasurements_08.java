import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][];

        List<int[]> correctMatrix = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = getArray(scanner);
        }

        int[] indexToReplace = getArray(scanner);

        System.out.println();
        int valueToReplace = matrix[indexToReplace[0]][indexToReplace[1]];


        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                int currentNum = matrix[r][c];
                if (currentNum == valueToReplace) {
                    int correctValue = getNearbySum(matrix, r, c, valueToReplace);
                    correctMatrix.add(new int[]{r, c, correctValue});

                }

            }
        }

        for (int[] arr : correctMatrix) {
            int row = arr[0];
            int col = arr[1];
            matrix[row][col] = arr[2];
        }

        for (int[] arr : matrix) {
            for (int n : arr) {
                System.out.print(n + " ");
            }
            System.out.println();

        }


    }

    private static int getNearbySum(int[][] matrix, int r, int c, int valueToReplace) {
        int sum = 0;
        if (isInBounds(matrix, r, c + 1) && matrix[r][c + 1] != valueToReplace) {
            sum += matrix[r][c + 1];
        }

        if (isInBounds(matrix, r, c - 1) && matrix[r][c - 1] != valueToReplace) {
            sum += matrix[r][c - 1];
        }

        if (isInBounds(matrix, r + 1, c) && matrix[r + 1][c] != valueToReplace) {
            sum += matrix[r + 1][c];
        }

        if (isInBounds(matrix, r - 1, c) && matrix[r - 1][c] != valueToReplace) {
            sum += matrix[r - 1][c];
        }


        return sum;
    }

    private static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static boolean isInBounds(int[][] matrix, int r, int c) {
        return r >= 0 && r < matrix.length && c >= 0 && c < matrix[r].length;
    }
}
