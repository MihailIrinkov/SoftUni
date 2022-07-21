import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        for (int i = 0; i < list.size(); i++) {
            int currentNum = list.get(i);
            if (currentNum < 0) {
                list.remove(i);
                i = -1;
            }
        }

        if (list.isEmpty()) {
            System.out.print("empty");
        } else {
            Collections.reverse(list);
            for (int num : list) {
                System.out.print(num + " ");
            }
        }
    }
}
