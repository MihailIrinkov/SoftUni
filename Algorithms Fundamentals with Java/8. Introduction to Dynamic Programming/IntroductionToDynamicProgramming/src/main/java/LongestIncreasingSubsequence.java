import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sequence = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] length = new int[sequence.length];

        for (int i = 0; i < sequence.length; i++) {
            int current = sequence[i];
            int bestLength = 1;

            for (int j = i - 1; j >= 0; j--) {
                if (sequence[j] < current && length[j] + 1 > bestLength) {
                    bestLength = length[j] + 1;
                }
            }

            length[i] = bestLength;
        }

        System.out.println(Arrays.stream(length).max().getAsInt());
    }
}
