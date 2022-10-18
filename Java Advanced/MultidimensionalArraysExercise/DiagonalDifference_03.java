import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dimension = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[dimension][];

        for (int i = 0; i < dimension; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int primaryDiagonal = 0;
        int secondaryDiagonal = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row == col) {
                    primaryDiagonal += matrix[row][col];
                }
            }
        }

        for (int row = matrix.length - 1, col = 0; row >= 0 && col < matrix[row].length; row--, col++) {
            secondaryDiagonal += matrix[row][col];

//            for (int col = 0; col < matrix[row].length; col++) {
//                secondaryDiagonal += matrix[row][col];
//                if (row > 0) {
//                    row--;
//                }
//            }
        }
        System.out.println(Math.abs(primaryDiagonal - secondaryDiagonal));
    }
}
