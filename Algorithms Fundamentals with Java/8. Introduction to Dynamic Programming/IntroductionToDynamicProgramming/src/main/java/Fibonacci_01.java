import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class Fibonacci_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        long fib = calcFib(n);

        System.out.println(fib);
    }

    private static long calcFib(int n) {
        if (n <= 2) {
            return 1;
        }

        return calcFib(n - 1) + calcFib(n - 2);
    }
}
