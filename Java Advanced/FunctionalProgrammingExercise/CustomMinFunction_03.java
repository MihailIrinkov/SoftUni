import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public interface CustomMinFunction_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+")).mapToInt(Integer::parseInt).toArray();

//        Function<int[], Integer> function = n -> {
//            int min = Integer.MAX_VALUE;
//
//            for (int number : n) {
//                if (number < min) {
//                    min = number;
//                }
//            }
//            return min;
//        };


        Function<int[], Integer> function = e -> Arrays.stream(e).min()
                .orElseThrow(() -> new IllegalArgumentException());

        int result = function.apply(numbers);
        System.out.println(result);

    }
}
