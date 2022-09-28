import java.util.Scanner;

public class ValidUsernames_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] userNames = input.split(", ");

        for (String user : userNames) {
            if (isValid(user)) {
                System.out.println(user);
            }

        }
    }

    public static boolean isValid(String user) {

        if (user.length() < 3 || user.length() > 16) {
            return false;
        }

        for (char symbol : user.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol) && symbol != '-' && symbol != '_') {
                return false;
            }

        }
        return true;
    }
}
