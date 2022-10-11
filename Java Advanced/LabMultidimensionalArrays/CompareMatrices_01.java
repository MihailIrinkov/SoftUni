import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int firstMatrixRow = dimensions[0];
        int firstMatrixCols = dimensions[1];

        int[][] firstMatrix = new int[firstMatrixRow][firstMatrixCols];


        for (int i = 0; i < firstMatrixRow; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            firstMatrix[i] = arr;
        }


        dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int secondMatrixRow = dimensions[0];
        int secondMatrixCols = dimensions[1];

        int[][] secondMatrix = new int[secondMatrixRow][secondMatrixCols];

        for (int i = 0; i < secondMatrixRow; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            secondMatrix[i] = arr;
        }
        System.out.println();

        if (matrixAreEqual(firstMatrix, secondMatrix)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }

    }

    static boolean matrixAreEqual(int[][] firstMatrix, int[][] secondmatrix) {
        if (firstMatrix.length != secondmatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondmatrix[row].length) {
                return false;
            }
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondmatrix[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }
}
