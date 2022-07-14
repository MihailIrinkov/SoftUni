import java.util.Scanner;

public class MiddleCharacters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        middleCharacters(text);

    }

    public static void middleCharacters(String word) {

        if (word.length() % 2 != 0) {
            int positionOdMiddleC = word.length() / 2;
            System.out.println(word.charAt(positionOdMiddleC));
        } else {
            int middlePositionOdd1 = word.length() / 2 - 1;
            int middlePositionOdd2 = word.length() / 2;
            System.out.println(word.charAt(middlePositionOdd1) + ""
                    + word.charAt(middlePositionOdd2));
        }

    }
}
