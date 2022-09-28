import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RepeatStrings_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split(" ");
        List<String> allRepeating = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            String current = arr[i];
            int n = current.length();

            String repeatWord = repeating(current, n);
            allRepeating.add(repeatWord);
        }

        System.out.println(String.join("", allRepeating));

    }

    public static String repeating(String str, int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += str;
        }
        return result;
    }
}
