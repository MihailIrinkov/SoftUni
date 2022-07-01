import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceEqualElements_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sequenceArr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int maxLength = 0;
        int length = 1;
        int startIndex = 0;
        int bestndex = 0;

        for (int i = 1; i < sequenceArr.length; i++) {
            if (sequenceArr[i] == sequenceArr[i - 1]) {
                length++;
            } else {
                length = 1;
                startIndex = i;
            }
            if (length > maxLength) {
                maxLength = length;
                bestndex = startIndex;
            }
        }
        for (int i = bestndex; i < bestndex + maxLength; i++) {
            System.out.print(sequenceArr[i] + " ");

        }

    }
}
