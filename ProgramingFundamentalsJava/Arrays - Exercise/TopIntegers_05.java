import java.util.Arrays;
import java.util.Scanner;

public class TopIntegers_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();


        for (int i = 0; i < array.length; i++) {
            int currentNum = array[i];

            if (i == array.length - 1) {
                System.out.print(currentNum + " ");
                break;
            }
            boolean lastDigit = false;

            for (int j = i + 1; j < array.length; j++) {
                int nextNumner = array[j];

                if (currentNum > nextNumner) {
                    lastDigit = true;
                } else {
                    lastDigit = false;
                    break;
                }


                }
            if (lastDigit) {
                System.out.print(currentNum + " ");

            }


        }
    }
}
