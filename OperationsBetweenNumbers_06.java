import java.util.Scanner;

public class OperationsBetweenNumbers_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOne = Integer.parseInt(scanner.nextLine());
        int numberTwo = Integer.parseInt(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);
        double sum = 0;
        String evenOrOdd = "";
        if (operator == '+') {
            sum = numberOne + numberTwo;
            if (sum % 2 == 0) {
                evenOrOdd = "even";

            } else {
                evenOrOdd = "odd";
            } System.out.printf("%d %c %d = %.0f - %s", numberOne, operator, numberTwo, sum, evenOrOdd);
        } else if (operator == '-') {
            sum = numberOne - numberTwo;
            if (sum % 2 == 0) {
                evenOrOdd = "even";

            }  else {
                evenOrOdd = "odd";
            } System.out.printf("%d %c %d = %.0f - %s", numberOne, operator, numberTwo, sum, evenOrOdd);

        } else if (operator == '*') {
            sum = numberOne * numberTwo;
            if (sum % 2 == 0) {
                evenOrOdd = "even";

            } else if (sum %2 != 0){
                evenOrOdd = "odd";

            } System.out.printf("%d %c %d = %.0f - %s", numberOne, operator, numberTwo, sum, evenOrOdd);

        }

        else if (operator == '/') {

            if (numberTwo == 0) {
                System.out.printf("Cannot divide %d by zero", numberOne);

            } else {
                sum = numberOne * 1.0 / numberTwo;
                System.out.printf("%d %c %d = %.2f", numberOne, operator, numberTwo, sum);
            }

        } else if (operator == '%') {
            if (numberTwo == 0) {
                System.out.printf("Cannot divide %d by zero", numberOne);

            } else {
                sum = numberOne % numberTwo;
                System.out.printf("%d %c %d = %.0f", numberOne, operator, numberTwo, sum);
            }


        }

    }
}
