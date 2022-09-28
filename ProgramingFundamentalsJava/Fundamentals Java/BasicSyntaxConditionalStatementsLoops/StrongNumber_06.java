import java.util.Scanner;

public class StrongNumber_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int startNumber = number;
        int sumFacNum = 0;

        while (number > 0) {
           int lastDigit = number % 10;
           int facNum = 1;

            for (int i = 1; i <= lastDigit; i++) {
                facNum = facNum * i;
            }
            sumFacNum = sumFacNum + facNum;

            number = number / 10;
        }
        if (startNumber == sumFacNum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
