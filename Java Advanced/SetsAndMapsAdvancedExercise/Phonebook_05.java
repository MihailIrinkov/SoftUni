import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, String> phoneBook = new HashMap<>();

        while (!input.equals("search")) {
            String[] data = input.split("-");
            String name = data[0];
            String phoneNumber = data[1];

            phoneBook.put(name, phoneNumber);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();

        while (!input.equals("stop")) {

            if (phoneBook.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, phoneBook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }

            input = scanner.nextLine();
        }

    }
}
