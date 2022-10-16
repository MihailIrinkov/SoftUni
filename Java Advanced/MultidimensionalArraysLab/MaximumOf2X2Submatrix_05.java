import java.util.Arrays;
import java.util.Scanner;

public class MaximumOf2X2Submatrix_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int row = dimension[0];
        int col = dimension[1];

        int[][] matrix = new int[row][col];

        int sumMax = Integer.MIN_VALUE;

        for (int r = 0; r < matrix.length; r++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[r] = arr;
        }

        int[][] arrMax = new int[2][2];

        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {

                int sum = matrix[r][c] + matrix[r][c + 1]
                        + matrix[r + 1][c] + matrix[r + 1][c + 1];
                if (sum > sumMax) {
                    sumMax = sum;

                    arrMax[0][0] = matrix[r][c];
                    arrMax[0][1] = matrix[r][c + 1];
                    arrMax[1][0] = matrix[r + 1][c];
                    arrMax[1][1] = matrix[r + 1][c + 1];

                }


            }
        }
        for (int r = 0; r < arrMax.length; r++) {
            for (int c = 0; c < arrMax[r].length; c++) {
                System.out.print(arrMax[r][c] + " ");
            }
            System.out.println();
        }

        System.out.println(sumMax);

    }
}
