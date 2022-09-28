import java.util.Scanner;

public class Calculations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());

        switch (command) {
            case "add":
                printAddNumbers(firstNumber, secondNumber);
                break;
            case "multiply":
                printMultiplyNumbers(firstNumber, secondNumber);
                break;
            case "subtract":
                printSubtractNumbers(firstNumber, secondNumber);
                break;
            case "divide":
                printDevideNumbers(firstNumber, secondNumber);
                break;
        }

    }

    public static void printAddNumbers(int n1, int n2) {
        System.out.println(n1 + n2);
    }

    public static void printMultiplyNumbers(int n1, int n2) {
        System.out.println(n1 * n2);
    }

    public static void printSubtractNumbers(int n1, int n2) {
        System.out.println(n1 - n2);
    }

    public static void printDevideNumbers(int n1, int n2) {
        System.out.println(n1 / n2);
    }
}
