import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SimpleCalculator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> calculator = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toCollection(ArrayDeque::new));
        int sum = 0;

        while (calculator.size() > 1) {
            int firstNum = Integer.parseInt(calculator.pop());
            String sign = calculator.pop();
            int secondNum = Integer.parseInt(calculator.pop());

            if (sign.equals("+")) {
                sum = firstNum + secondNum;

            } else if (sign.equals("-")) {
                sum = firstNum - secondNum;
            }

            calculator.push(String.valueOf(sum));

        }

        System.out.println(sum);

    }
}
