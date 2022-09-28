import java.util.Arrays;
import java.util.Scanner;

public class EvenAndOddSubtraction_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int sumEven = 0;
        int sumOdd = 0;
        for (int currentNumberArr : numArr) {
            if (currentNumberArr % 2 == 0) {
                sumEven += currentNumberArr;
            } else {
                sumOdd += currentNumberArr;
            }
        }
        int diff = sumEven - sumOdd;
        System.out.println(diff);
    }
}
