import java.util.Scanner;

public class TopNumber_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i < n; i++) {
            if (sumDigitsDivisible(i) && holdOddDigit(i)) {
                System.out.println(i);
            }

        }
    }

    public static boolean sumDigitsDivisible(int num) {
        int sumDigits = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            sumDigits += lastDigit;
            num /= 10;
        }
        if (sumDigits % 8 == 0) {
            return true;
        }
        return false;
    }

    public static boolean holdOddDigit(int num) {

        while (num > 0) {
            int digit = num % 10;
            if (digit % 2 != 0) {
                return true;
            }

            num /= 10;
        }
        return false;
    }

}
