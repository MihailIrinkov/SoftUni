import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split("\\s+")[0]);
        int cols = Integer.parseInt(input.split("\\s+")[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }
        rows--;
        cols--;

        while (rows != -1) {
            int r = rows;
            int c = cols;

            while (!isInBound(r, c, matrix)) {
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            cols--;
            if (cols < 0) {
                cols = 0;
                rows--;
            }
        }


    }

    public static boolean isInBound(int row, int col, int[][] matrix) {
        return row < 0 || col < 0 || row > matrix.length - 1 || col > matrix[0].length - 1;
    }
}
