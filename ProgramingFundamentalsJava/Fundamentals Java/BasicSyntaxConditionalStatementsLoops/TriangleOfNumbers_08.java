import java.util.Scanner;

public class TriangleOfNumbers_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int number = 0;
        for (int i = 1; i <= n; i++) {
            number++;
            System.out.println();
            for (int j = 1; j <= number; j++) {
                System.out.printf(number + " ");
            }

        }
    }
}
