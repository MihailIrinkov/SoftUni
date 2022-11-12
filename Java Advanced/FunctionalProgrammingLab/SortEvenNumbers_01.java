import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortEvenNumbers_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        List<String> sortedEvenNumbers = Arrays.stream(input)
                .map(e -> Integer.parseInt(e))
                .filter(e -> e % 2 == 0)
                .sorted()
                .map(e -> e.toString())
                .collect(Collectors.toList());

        List<String> unsorted = Arrays.stream(input)
                .map(e -> Integer.parseInt(e))
                .filter(e -> e % 2 == 0)
                .map(e -> e.toString())
                .collect(Collectors.toList());

        String print = String.join(", ", sortedEvenNumbers);

        System.out.println(String.join(", ", unsorted));

        System.out.println(print);

    }
}
