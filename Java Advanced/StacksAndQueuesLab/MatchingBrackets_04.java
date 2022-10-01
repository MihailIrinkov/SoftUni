import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (symbol == '(') {
                stack.push(i);


            } else if (symbol == ')') {
                int startIndex = stack.pop();
                String expression = input.substring(startIndex, i + 1);
                System.out.println(expression);
            }
        }
    }
}
