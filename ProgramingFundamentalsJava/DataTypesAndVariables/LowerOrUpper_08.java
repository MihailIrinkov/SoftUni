import java.util.Scanner;

public class LowerOrUpper_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char letter = scanner.nextLine().charAt(0);

//        if (letter >= 'a' && letter <= 'z') {
//            System.out.println("lower-case");
//        } else if (letter >= 'A' && letter <= 'Z') {
//            System.out.println("upper-case");
//        }



        if (Character.isLowerCase(letter)) {
            System.out.println("lower-case");
        } else if (Character.isUpperCase(letter)) {
            System.out.println("upper-case");
        }
    }
}
