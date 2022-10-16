import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);

        String[][] matrix = new String[row][col];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                char firstChar = (char) ('a' + i);
                char middleChar = (char) ('a' + i + j);


                matrix[i][j] = "" + firstChar + middleChar + firstChar;

            }

        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
    }
}
