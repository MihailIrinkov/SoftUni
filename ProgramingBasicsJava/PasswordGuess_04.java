import java.util.Scanner;

public class PasswordGuess_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if ("s3cr3t!P@ssw0rd".equals(password)){
            System.out.println("Welcome");
        }else
            System.out.println("Wrong password!");
    }

}
