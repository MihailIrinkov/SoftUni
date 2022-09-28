import java.util.Scanner;

public class CharactersInRange_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char one = scanner.nextLine().charAt(0);
        char two = scanner.nextLine().charAt(0);
        charInRange(one, two);
    }

    public static void charInRange(char one, char two) {
        if (two > one) {
            for (char i = (char) (one + 1); i < two; i++) {
                System.out.print(i + " ");
            }
        } else {
            for (char i = (char) (two + 1); i < one; i++) {
                System.out.print(i + " ");
            }
        }
    }
}
