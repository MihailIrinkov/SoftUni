import javax.security.sasl.SaslClient;
import java.util.Scanner;

public class Fibonacci_01 {
    public static long[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        dp = new long[n + 1];

        long fib = calcFib(n);

        System.out.println(fib);


//        dp[1] = 1;
//        dp[2] = 1;
//
//        for (int i = 3; i < n; i++) {
//            dp[i] = dp[i - 1] + dp[i - 2];
//        }
//        System.out.println(dp[n]);
    }

    private static long calcFib(int n) {
        if (n <= 2) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        return dp[n] = calcFib(n - 1) + calcFib(n - 2);
    }
}
