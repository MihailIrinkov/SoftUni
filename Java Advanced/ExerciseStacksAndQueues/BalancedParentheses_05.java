import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = true;

        for (int i = 0; i < input.length(); i++) {
            char currentBracket = input.charAt(i);

            if (currentBracket == '(' || currentBracket == '{' || currentBracket == '[') {
                stack.push(currentBracket);
            } else {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }


                char lastOpeningBracket = stack.pop();
                if (lastOpeningBracket != '(' && currentBracket == ')') {
                    isBalanced = false;
                    break;
                } else if (lastOpeningBracket != '[' && currentBracket == ']') {
                    isBalanced = false;
                    break;
                } else if (lastOpeningBracket != '{' && currentBracket == '}') {
                    isBalanced = false;
                    break;
                }
            }


        }

        if (isBalanced && stack.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
