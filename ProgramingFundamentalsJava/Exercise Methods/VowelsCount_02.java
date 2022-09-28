import java.lang.reflect.Array;
import java.util.Locale;
import java.util.Scanner;

public class VowelsCount_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine().toLowerCase(Locale.ROOT);

        vowelsCount(text);

    }

    public static void vowelsCount(String text) {
        int countVowels = 0;
        for (char symbol : text.toCharArray()) {
            if (symbol == 'a' || symbol == 'e' || symbol == 'i'
                    || symbol == 'o' || symbol == 'u') {
                countVowels++;
            }

        }
        System.out.println(countVowels);
    }
}
