import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int listLengthMin = Math.min(firstList.size(), secondList.size());
        List<Integer> sumList = new ArrayList<>();

        for (int i = 0; i < listLengthMin; i++) {
            int first = firstList.get(i);
            int second = secondList.get(i);
            sumList.add(first);
            sumList.add(second);
        }

        if (firstList.size() > secondList.size()) {
            sumList.addAll(firstList.subList(listLengthMin, firstList.size()));
        } else {
            sumList.addAll(secondList.subList(listLengthMin, secondList.size()));
        }
        for (int num : sumList) {
            System.out.print(num + " ");
        }
    }
}
