import java.util.Scanner;

public class RageExpenses_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gameLose = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int headsetCount = gameLose / 2;
        int mouseCount = gameLose / 3;
        int keyboardCount = gameLose / 6;
        int displayCount = gameLose / 12;

        double sumExpenses = (headsetPrice * headsetCount) + (mousePrice * mouseCount)
                + (keyboardPrice * keyboardCount) + (displayPrice * displayCount);

        System.out.printf("Rage expenses: %.2f lv.", sumExpenses);

    }
}
