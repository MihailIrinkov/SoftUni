import java.util.ArrayDeque;
import java.util.Scanner;

public class MagicBox_01_Sep_2021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxQue = new ArrayDeque<>();
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();

        String[] first = scanner.nextLine().split(" ");
        String[] second = scanner.nextLine().split(" ");

        for (int i = 0; i < first.length; i++) {
            firstBoxQue.offer(Integer.parseInt(first[i]));
        }

        for (int i = 0; i < second.length; i++) {
            secondBoxStack.push(Integer.parseInt(second[i]));
        }

        int claimedItems = 0;

        while (!firstBoxQue.isEmpty() && !secondBoxStack.isEmpty()) {

            int firstNum = firstBoxQue.peek();
            int secondNum = secondBoxStack.peek();
            int currentSum = firstNum + secondNum;

            if (currentSum % 2 == 0) {
                claimedItems += currentSum;
                firstBoxQue.poll();
                secondBoxStack.pop();
            } else {
                firstBoxQue.offer(secondNum);
                secondBoxStack.pop();
            }
        }

        if (firstBoxQue.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else if (secondBoxStack.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }

        if (claimedItems >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d", claimedItems);
        } else {
            System.out.printf("Poor prey... Value: %d", claimedItems);
        }

    }
}
