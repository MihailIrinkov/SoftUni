import java.util.Scanner;

public class SquareRoot_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();


        try {
            int num = Integer.parseInt(input);
            if (num > 0) {
                double sqrt = calcSqrt(num);

                System.out.printf("%.2f%n", sqrt);
            } else {
                System.out.println("Invalid");
            }


        } catch (IllegalArgumentException e) {
            System.out.println("Invalid");

        } finally {
            System.out.println("Goodbye");
        }
    }

    private static double calcSqrt(int num) {
        return Math.sqrt(num);
    }
}
