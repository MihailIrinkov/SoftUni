package CardSuit_01;

public class Main {
    public static void main(String[] args) {


        System.out.println("Card Suits:");

        for (CardSuit c: CardSuit.values()) {

            System.out.printf("Ordinal value: %d; Name value: %s%n",
                    c.ordinal(), c.name());
        }
    }
}
