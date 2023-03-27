import java.util.Scanner;

public class NumberInRange_01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int startIndex = Integer.parseInt(input[0]);
        int endIndex = Integer.parseInt(input[1]);

        System.out.printf("Range: [%d...%d]%n", startIndex, endIndex);

        int num = numberInRange(scanner, startIndex, endIndex);

        System.out.printf("Valid number: %d%n", num);

    }

    public static int numberInRange(Scanner scanner, int start, int end) {

        while (true) {
            String number = scanner.nextLine();
            try {
                int currentNumber = Integer.parseInt(number);
                if (currentNumber <= end &&
                        currentNumber >= start) {
                    return currentNumber;
                }


            } catch (IllegalArgumentException e) {

            }
            System.out.printf("Invalid number: %s%n", number);

        }

    }
}
