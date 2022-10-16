import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimension = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = dimension[0];
        int colum = dimension[1];

        int[][] matrix = new int[row][colum];

        for (int r = 0; r < matrix.length; r++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[r] = arr;
        }
        int num = Integer.parseInt(scanner.nextLine());

        boolean isFound = false;

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == num) {
                    System.out.println(r + " " + c);
                    isFound = true;
                }

            }

        }

        if (!isFound) {
            System.out.println("not found");
        }

    }
}
