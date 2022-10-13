import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = dimension[0];
        int col = dimension[1];

        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        int sum = 0;
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < matrix[i].length; j++) {

                int currentNum = matrix[i][j];
                sum += currentNum;
            }
        }

        System.out.println(sum);

    }
}
