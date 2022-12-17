import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LootBox_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input1 = scanner.nextLine().split(" ");
        String[] input2 = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> firstBoxQue = new ArrayDeque<>();
        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();

        List<Integer> claimedItems = new ArrayList<>();

        for (int i = 0; i < input1.length; i++) {
            int current = Integer.parseInt(input1[i]);
            firstBoxQue.offer(current);
        }

        for (int i = 0; i < input2.length; i++) {
            int current2 = Integer.parseInt(input2[i]);
            secondBoxStack.push(current2);
        }

        while (!firstBoxQue.isEmpty() && !secondBoxStack.isEmpty()) {
            int sum = firstBoxQue.peek() + secondBoxStack.peek();
            if (sum % 2 == 0) {
                claimedItems.add(sum);
                firstBoxQue.poll();
                secondBoxStack.pop();
            } else {
                firstBoxQue.offer(secondBoxStack.peek());
                secondBoxStack.pop();
            }
        }

        if (firstBoxQue.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else if (secondBoxStack.isEmpty()) {
            System.out.println("Second lootbox is empty");
        }

        int qualityOfClaimedItems = 0;

        for (int i = 0; i < claimedItems.size(); i++) {
            int currentC = claimedItems.get(i);

            qualityOfClaimedItems += currentC;
        }

        if (qualityOfClaimedItems >= 100) {
            System.out.printf("Your loot was epic! Value: %d", qualityOfClaimedItems);
        } else {
            System.out.printf("Your loot was poor... Value: %d", qualityOfClaimedItems);
        }
    }
}
