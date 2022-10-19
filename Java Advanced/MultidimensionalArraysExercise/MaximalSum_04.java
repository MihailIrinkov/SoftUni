import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int maxSum = Integer.MIN_VALUE;

        int bestRow = 0;
        int bestCol = 0;


        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {

//                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
//                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
//                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                int sum = 0;
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                       int currentSum = matrix[i][j];
                       sum += currentSum;
                    }
                }


                if (sum > maxSum) {
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }

        System.out.printf("Sum = " + maxSum);
        System.out.println();

        for (int i = bestRow; i < bestRow + 3; i++) {
            for (int j = bestCol; j < bestCol + 3; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
