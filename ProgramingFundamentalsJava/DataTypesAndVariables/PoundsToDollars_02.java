import java.util.Scanner;

public class PoundsToDollars_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float pound = Float.parseFloat(scanner.nextLine());
        float usDollars = pound * 1.36f;

        System.out.printf("%.3f", usDollars);
    }
}
