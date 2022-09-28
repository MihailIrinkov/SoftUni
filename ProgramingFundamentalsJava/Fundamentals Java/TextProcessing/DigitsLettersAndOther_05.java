import java.util.Scanner;

public class DigitsLettersAndOther_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder characters = new StringBuilder();


        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = text.charAt(i);
            if (Character.isDigit(currentSymbol)) {
                digits.append(currentSymbol);
            } else if (Character.isLetter(currentSymbol)) {
                letters.append(currentSymbol);
            } else {
                characters.append(currentSymbol);
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(characters);
    }
}
