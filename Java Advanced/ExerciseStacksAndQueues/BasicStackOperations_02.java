import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] n = scanner.nextLine().split(" ");

        int numbersToPush = Integer.parseInt(n[0]);
        int numbersToPop = Integer.parseInt(n[1]);
        int numbersToCheck = Integer.parseInt(n[2]);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        String [] numbers = scanner.nextLine().split(" ");



        for (int i = 0; i < numbersToPush; i++) {
            stack.push(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < numbersToPop; i++) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            System.out.println(0);
        } else if (stack.contains(numbersToCheck)) {
            System.out.println("true");
        } else {
            int min = Integer.MAX_VALUE;
            for (int num : stack) {
                if (num < min) {
                    min = num;
                }
            }
            System.out.println(min);
        }
    }
}
