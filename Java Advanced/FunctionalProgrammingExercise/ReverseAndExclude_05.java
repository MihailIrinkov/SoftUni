import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        Collections.reverse(list);

        int num = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> predicate = e -> e % num == 0;

        list.removeIf(predicate);

        list.forEach(e -> System.out.print(e + " "));

    }
}
