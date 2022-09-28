import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class MultiplyEvensByOdds_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Math.abs(Integer.parseInt(scanner.nextLine()));

        System.out.println(multipleOfEvenOddSum(num));

    }

    public static int multipleOfEvenOddSum(int num) {
        int sumTotal = evenSum(num) * oddSum(num);
return sumTotal;

    }

    public static int evenSum(int num) {
        String intToString = Integer.toString(num);
        int[] array = Arrays.stream(intToString.split(""))
                .mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                sum += array[i];
            }
        }
        return sum;
    }

    public static int oddSum(int num) {
        String intToString = Integer.toString(num);
        int[] array = Arrays.stream(intToString.split(""))
                .mapToInt(Integer::parseInt).toArray();
        int sum =0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0) {
                sum += array[i];
            }
        }
        return sum;
    }
}
