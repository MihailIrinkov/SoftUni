import java.util.Scanner;
import java.util.function.BiFunction;

public class SumNumbers_02_Bi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        BiFunction<Integer, String, Integer> biFunction = (x, y)  -> x + Integer.parseInt(y);

        int sum = 0;

        System.out.println("Count = " + input.length);

        for (int i = 0; i < input.length; i++) {
            sum = biFunction.apply(sum, input[i]);
        }
        System.out.println("Sum = " + sum);
    }
}
