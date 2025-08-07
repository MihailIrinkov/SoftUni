import java.util.Scanner;

public class Stairs_02 {

    private static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int stairs = Integer.parseInt(scanner.nextLine());

        if (stairs == 0) {
            System.out.println(0);
            return;
        }

        memory = new long[stairs + 1];

        System.out.println(climbStairs(stairs));

    }

    private static long climbStairs(int stairs) {

        if (memory[stairs] != 0) {
            return memory[stairs];
        }

        if (stairs == 1) {
            return 1;
        } else if (stairs == 2) {
            return 2;
        }

        long result = climbStairs(stairs - 1) + climbStairs(stairs - 2);

        memory[stairs] = result;

        return result;
    }
}
