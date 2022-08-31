import java.util.Scanner;

public class ReverseStrings_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String result = "";
            for (int i = command.length() - 1; i >= 0; i--) {
                char symbol = command.charAt(i);
                result += symbol;
            }

            System.out.printf("%s = %s%n", command, result);

            command = scanner.nextLine();
        }

    }
}
