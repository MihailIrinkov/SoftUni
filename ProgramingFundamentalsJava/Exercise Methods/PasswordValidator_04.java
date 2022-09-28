import java.util.Scanner;

public class PasswordValidator_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        boolean isLengthValid = passwordLengthValid(password);

        if (!isLengthValid) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        boolean istDigitsLetters = consistDigitsLetters(password);
        if (!istDigitsLetters) {
            System.out.println("Password must consist only of letters and digits");
        }

        boolean twoDigits = atLeastTwoDigits(password);
        if (!twoDigits) {
            System.out.println("Password must have at least 2 digits");
        }

        if (isLengthValid && istDigitsLetters && twoDigits) {
            System.out.println("Password is valid");
        }


    }

    public static boolean passwordLengthValid(String password) {
        if (password.length() >= 6 && password.length() <= 10) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean consistDigitsLetters(String password) {
        for (char symbol : password.toCharArray()) {
            if (!Character.isLetterOrDigit(symbol)) {
                return false;
            }

        }
        return true;
    }

    public static boolean atLeastTwoDigits(String password) {
        int count = 0;
        for (char symbol : password.toCharArray()) {
            if (Character.isDigit(symbol)) {
                count++;
            }

        }
        if (count >= 2) {
            return true;
        } else {
            return false;
        }
    }

}
