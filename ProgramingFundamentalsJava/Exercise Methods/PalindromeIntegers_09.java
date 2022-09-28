import java.util.Scanner;

public class PalindromeIntegers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();

        while (!num.equals("END")) {
            if (palindromeInt(num).equals(num)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            num = scanner.nextLine();
        }
    }

    public static String palindromeInt(String input) {
        String palindrome = "";
        for (int i = input.length() - 1; i >= 0; i--) {
            palindrome += input.charAt(i);
        }
        return palindrome;
    }
}
