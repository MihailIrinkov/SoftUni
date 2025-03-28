import java.util.*;

public class HandsOfCards_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Set<String>> players = new LinkedHashMap<>();

        while (!input.equals("JOKER")) {
            String[] parts = input.split(": ");

            String name = parts[0];

            String[] cards = parts[1].split(", ");

            if (!players.containsKey(name)) {
                players.put(name, new HashSet<>());

                for (int i = 0; i < cards.length; i++) {
                    String currentCard = cards[i];
                    players.get(name).add(currentCard);
                }

            } else {
                for (int i = 0; i < cards.length; i++) {
                    String currentCard = cards[i];
                    players.get(name).add(currentCard);
                }

            }

            input = scanner.nextLine();
        }

        players.entrySet().stream()
                .forEach(e ->
                {
                    String name = e.getKey();
                    int points = getPoints(e);
                    System.out.printf("%s: %d%n", name, points);
                });

    }

    private static int getPoints(Map.Entry<String, Set<String>> e) {
        int points = 0;

        for (String card : e.getValue()) {
            String power = card.substring(0, card.length() - 1);
            String color = card.substring(card.length() - 1);
            int cardPoints = getPower(power) * getColor(color);
            points += cardPoints;
        }

        return points;
    }

    private static int getColor(String color) {
        switch (color) {
            case "S":
                return 4;
            case "H":
                return 3;
            case "D":
                return 2;
            case "C":
                return 1;

        }
        return 0;
    }

    private static int getPower(String power) {

        switch (power) {
            case "1":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
                return 10;
            case "J":
                return 11;
            case "Q":
                return 12;
            case "K":
                return 13;
            case "A":
                return 14;
        }
        return 0;
    }
}
