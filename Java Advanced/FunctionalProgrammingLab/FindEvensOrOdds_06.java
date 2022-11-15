import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensOrOdds_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        String command = scanner.nextLine();

        int start = Integer.parseInt(input[0]);
        int end = Integer.parseInt(input[1]);

        List<Integer> listNum = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            listNum.add(i);
        }


        Predicate<Integer> filterPredicate;

        if (command.equals("even")) {
            filterPredicate = e -> e % 2 == 0;
        } else {
            filterPredicate = e -> e % 2 != 0;
        }

        listNum.stream()
                .filter(filterPredicate)
                .forEach(e -> System.out.print(e + " "));

    }
}
