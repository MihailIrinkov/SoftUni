package CardsWithPower_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RankPower rankPower = RankPower.valueOf(scanner.nextLine());
        SuitPower suitPower = SuitPower.valueOf(scanner.nextLine());

        System.out.printf("Card name: %s of %s; " +
                "Card power: %d", rankPower.name(), suitPower.name(),
                rankPower.getPower() + suitPower.getPower());
    }
}
