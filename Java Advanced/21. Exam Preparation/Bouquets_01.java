import java.util.ArrayDeque;
import java.util.Scanner;

public class Bouquets_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tulipsArray = scanner.nextLine().split(", ");
        String[] daffodilsArray = scanner.nextLine().split(", ");

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        ArrayDeque<Integer> daffodilsQue = new ArrayDeque<>();

        for (int i = 0; i < tulipsArray.length; i++) {
            tulipsStack.push(Integer.parseInt(tulipsArray[i]));
        }
        for (int i = 0; i < daffodilsArray.length; i++) {
            daffodilsQue.offer(Integer.parseInt(daffodilsArray[i]));
        }

        int bouquets = 0;
        int leftFlowers = 0;

        while (!tulipsStack.isEmpty() && !daffodilsQue.isEmpty()) {
            int sum = tulipsStack.peek() + daffodilsQue.peek();
            if (sum == 15) {
                tulipsStack.pop();
                daffodilsQue.poll();
                bouquets++;
            } else if (sum > 15) {
                int currentTulipsN = tulipsStack.pop();
                tulipsStack.push(currentTulipsN - 2);
            } else {
                int left = tulipsStack.pop() + daffodilsQue.poll();
                leftFlowers += left;
            }

        }

        bouquets = bouquets + (leftFlowers / 15);

        if (bouquets >= 5) {
            System.out.printf("You made it! You go to " +
                    "the competition with %d bouquets!", bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }

    }
}
