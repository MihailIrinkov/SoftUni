import java.util.Arrays;
import java.util.Scanner;

public class SumEvenNumbers_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int[] arrayNumber = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for (int i = 0; i < arrayNumber.length; i++) {
            int currentArr = arrayNumber[i];
            if (currentArr % 2 == 0) {
                sum += currentArr;
            }
        }
        System.out.println(sum);
    }
}
