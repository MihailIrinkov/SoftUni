import java.util.Scanner;

public class SumDigits_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());

        int sum = 0;

        while (number > 0) {
            int currentNumber = number % 10;
            sum = sum + currentNumber;

            number /= 10;
        }
        System.out.println(sum);
    }
}
