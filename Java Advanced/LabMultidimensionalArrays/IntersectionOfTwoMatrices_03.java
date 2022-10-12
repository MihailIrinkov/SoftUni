import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = Integer.parseInt(scanner.nextLine());
        int col = Integer.parseInt(scanner.nextLine());

        char[][] matrixOne = new char[row][col];
        char[][] matrixTwo = new char[row][col];

        for (int i = 0; i < row; i++) {
            String s = scanner.nextLine();
            char[] arr = s.toCharArray();
            matrixOne[i] = arr;
        }
        for (int i = 0; i < row; i++) {
            String s = scanner.nextLine();
            char[] arr = s.toCharArray();
            matrixTwo[i] = arr;
        }

        for (int r = 0; r < matrixOne.length; r++) {
            for (int c = 0; c < matrixOne[r].length; c++) {
                char currentOne = matrixOne[r][c];
                char currentTwo = matrixTwo[r][c];
                if (currentTwo == currentOne) {
                    System.out.print(currentTwo);
                } else {
                    System.out.print('*');
                }
            }
            System.out.println();
        }

    }
}
