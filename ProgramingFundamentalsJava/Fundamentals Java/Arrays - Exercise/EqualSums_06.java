import java.util.Arrays;
import java.util.Scanner;

public class EqualSums_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean isNotFound = false;
        for (int index = 0; index <= numbers.length - 1; index++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int leftIndex = 0; leftIndex < index; leftIndex++) {
                leftSum += numbers[leftIndex];
            }
            for (int rightIndex = index + 1; rightIndex <= numbers.length - 1; rightIndex++) {
                rightSum += numbers[rightIndex];

            }


            if (leftSum == rightSum) {
                System.out.println(index);
                isNotFound = true;
                break;
            }


        }


        if (!isNotFound) {
            System.out.println("no");
        }


    }
}
