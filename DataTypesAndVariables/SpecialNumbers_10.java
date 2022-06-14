import java.util.Scanner;

public class SpecialNumbers_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            int num = i;
            while (num != 0) {
                int sum = 0;
                num = num % 10;
                sum += num;

                sum = sum + (i / 10);
                if (sum == 5 || sum == 7 || sum == 11) {
                    System.out.printf("%d -> True%n", i);
                } else {
                    System.out.printf("%d -> False%n", i);
                }
                num = num / 10;
            }
        }
    }
}
