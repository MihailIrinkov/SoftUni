import java.util.Arrays;
import java.util.Scanner;

public class MagicSum_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int givenNum = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < array.length; i++) {
            int num = array[i];

            for (int j = i + 1; j < array.length; j++) {

                if (num + array[j] == givenNum) {
                    System.out.println(num + " " + array[j]);
                }
            }
        }
    }
}
