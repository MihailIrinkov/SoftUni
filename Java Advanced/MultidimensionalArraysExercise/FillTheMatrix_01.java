import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int dimension = Integer.parseInt(input[0]);
        String pattern = input[1];

        int counter = 1;

        int[][] matrix = new int[dimension][dimension];

        if (pattern.equals("A")) {
            fillMatrixPatternA(dimension, counter, matrix);
        } else {

            fillMatrixPatternB(dimension, counter, matrix);

        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");

            }
            System.out.println();
        }

    }

    private static void fillMatrixPatternB(int dimension, int counter, int[][] matrix) {
        for (int col = 0; col < dimension; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < dimension; row++) {
                    matrix[row][col] = counter;
                    counter++;
                }
            } else {
                for (int row = dimension - 1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }

            }

        }
    }

    private static void fillMatrixPatternA(int dimension, int counter, int[][] matrix) {
        for (int col = 0; col < dimension; col++) {
            for (int row = 0; row < dimension; row++) {
                matrix[row][col] = counter;
                counter++;
            }
        }
//        for (int row = 0; row < matrix.length; row++) {
//            for (int col = 0; col < matrix[row].length; col++) {
//                System.out.print(matrix[row][col] + " ");
//            }
//            System.out.println();
//        }
    }
}
