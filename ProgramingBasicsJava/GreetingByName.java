import java.util.Scanner;

public class GreetingByName {
    public static void main(String[] args) {
        //"Hello, <name>!",
        try (Scanner scanner = new Scanner(System.in)) {
            String name = scanner.nextLine();
            System.out.printf("Hello, %s!", name);
        }

    }
}
