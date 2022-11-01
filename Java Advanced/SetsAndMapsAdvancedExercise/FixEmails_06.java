import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails_06 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, String> mailList = new LinkedHashMap<>();

        while (!input.equals("stop")) {

            String name = input;
            String mail = scanner.nextLine();

            if (!mail.endsWith("us") && !mail.endsWith("uk") && !mail.endsWith("com")) {
                mailList.put(name, mail);
            }

            input = scanner.nextLine();
        }

        mailList.entrySet().stream()
                .forEach(e -> {
                    System.out.printf("%s -> %s%n", e.getKey(), e.getValue());
                });

    }
}
