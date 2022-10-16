import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int numbersToOffer = Integer.parseInt(input[0]);
        int numbersToPoll = Integer.parseInt(input[1]);
        int numberToCheck = Integer.parseInt(input[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        String[] numbers = scanner.nextLine().split(" ");

        for (int i = 0; i < numbersToOffer; i++) {
            queue.offer(Integer.parseInt(numbers[i]));
        }
        for (int i = 0; i < numbersToPoll; i++) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println(0);
        } else if (queue.contains(numberToCheck)) {
            System.out.println("true");
        } else {
            System.out.println(Collections.min(queue));
        }

    }
}
