package CardRank_02;

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Ranks:");

        for (CardRank c : CardRank.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n",
                    c.ordinal(), c.name());
        }
    }
}
