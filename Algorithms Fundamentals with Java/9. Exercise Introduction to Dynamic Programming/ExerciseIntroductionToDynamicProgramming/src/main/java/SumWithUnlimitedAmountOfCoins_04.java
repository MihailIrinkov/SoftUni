import java.util.Arrays;
import java.util.Scanner;

public class SumWithUnlimitedAmountOfCoins_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] coins = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int targetSum = Integer.parseInt(scanner.nextLine());

        int[] dp = new int[targetSum + 1];

        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= targetSum; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        System.out.println(dp[targetSum]);
    }
}
