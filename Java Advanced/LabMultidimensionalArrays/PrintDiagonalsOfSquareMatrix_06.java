import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixLength = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[matrixLength][];

        for (int i = 0; i < matrixLength; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = arr;

        }

        int row = 0;
        int col = 0;

        while (row <= matrix.length - 1 && col <= matrix.length - 1) {
            System.out.print(matrix[row][col] + " ");
            row++;
            col++;
        }

        System.out.println();
        int row2 = matrix.length - 1;
        int col2 = 0;

        while (row2 >= 0 && col2 >= 0) {

            System.out.print(matrix[row2][col2] + " ");
            row2--;
            col2++;
        }

    }
}
