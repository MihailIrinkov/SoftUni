import java.util.Scanner;

public class ZigZagArrays_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] firstArray = new int[n];
        int[] secondArray = new int[n];

        for (int row = 1; row <= n; row++) {
            String numbers = scanner.nextLine();
            int firstNumber = Integer.parseInt(numbers.split(" ")[0]);
            int secondNumber = Integer.parseInt(numbers.split(" ")[1]);

            if (row % 2 == 0) {
                firstArray[row - 1] = secondNumber;
                secondArray[row - 1] = firstNumber;
            } else {
                firstArray[row - 1] = firstNumber;
                secondArray[row - 1] = secondNumber;
            }

        }
        for (int symbol : firstArray) {
            System.out.print(symbol + " ");
        }
        System.out.println();
        for (int number : secondArray) {
            System.out.print(number + " ");
        }
    }
}
