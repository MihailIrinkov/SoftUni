import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

//        Predicate<String> predicate = e -> e.length() % num != 0 && e.length() > num ;
//        names.removeIf(predicate);
//
//        for (String s : names) {
//            System.out.println(s);
//        }

        Predicate<String> predicate = e -> e.length() <= num;

        names.stream().filter(predicate).forEach(e -> System.out.println(e));

    }
}
