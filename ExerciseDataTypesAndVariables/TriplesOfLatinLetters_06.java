import java.util.Scanner;

public class TriplesOfLatinLetters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (char i = 'a'; i < 'a' + n; i++) {

            for (char b = 'a'; b < 'a' + n; b++) {

                for (char c = 'a'; c < 'a' + n; c++) {
                    System.out.printf("%c%c%c%n", i, b, c);
                }
            }
        }
    }
}
