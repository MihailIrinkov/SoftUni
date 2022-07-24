import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstHand = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondHand = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (firstHand.size() > 0 || secondHand.size() > 0) {

            if (firstHand.size() == 0 || secondHand.size() == 0) {
                break;
            }
            int firstDeck = firstHand.get(0);
            int secondDeck = secondHand.get(0);

            if (firstDeck > secondDeck) {
                firstHand.remove(0);
                firstHand.add(firstDeck);
                firstHand.add(secondDeck);
                secondHand.remove(0);

            } else if (secondDeck > firstDeck) {
                secondHand.remove(0);
                secondHand.add(secondDeck);
                secondHand.add(firstDeck);
                firstHand.remove(0);

            } else if (firstDeck == secondDeck) {
                firstHand.remove(0);
                secondHand.remove(0);
            }

        }

        if (firstHand.size() > secondHand.size()) {

            int sum = 0;

            for (int j = 0; j < firstHand.size(); j++) {
                sum += firstHand.get(j);
            }

            System.out.printf("First player wins! Sum: %d", sum);

        } else {

            int sum = 0;

            for (int j = 0; j < secondHand.size(); j++) {
                sum += secondHand.get(j);
            }
            System.out.printf("Second player wins! Sum: %d", sum);

        }

    }
}
