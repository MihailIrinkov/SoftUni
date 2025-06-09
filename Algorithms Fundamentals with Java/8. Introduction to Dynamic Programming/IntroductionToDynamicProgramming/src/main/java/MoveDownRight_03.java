import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MoveDownRight_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        int[][] elements = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            elements[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] table = new int[rows][cols];

        table[0][0] = elements[0][0];

        for (int col = 1; col < cols; col++) {
            table[0][col] = table[0][col - 1] + elements[0][col];
        }

        for (int row = 1; row < rows; row++) {
            table[row][0] = table[row - 1][0] + elements[row][0];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                table[row][col] = Math.max(table[row - 1][col] + elements[row][col],
                        table[row][col - 1] + elements[row][col]);
            }
        }

        int row = rows - 1;
        int col = cols - 1;

        List<String> path = new ArrayList<>();

        path.add(formatOutput(row, col));

        while (row >= 0 || col >= 0) {
            int top = table[row - 1][col];
            int left = table[row][col - 1];

            if (top > left) {
                row--;
            } else {
                col--;
            }

            path.add(formatOutput(row, col));
        }
    }

    private static String formatOutput(int row, int col) {
        return "[" + row + ", " + col + "]";
    }
}
