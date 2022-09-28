import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double num1 = Double.parseDouble(scanner.nextLine());
        String symbol = scanner.nextLine();
        double num2 = Double.parseDouble(scanner.nextLine());

        DecimalFormat df = new DecimalFormat("0.####");
        double result = calculate(num1, symbol, num2);
        System.out.println(df.format(result));

    }

    public static double calculate(double num1, String symbol, double num2) {
        double sum = 0;
        switch (symbol) {
            case "/":
                sum = num1 / num2;
                break;
            case "*":
                sum = num1 * num2;
                break;
            case "+":
                sum = num1 + num2;
                break;
            case "-":
                sum = num1 - num2;
                break;
        }
        return sum;
    }

}
