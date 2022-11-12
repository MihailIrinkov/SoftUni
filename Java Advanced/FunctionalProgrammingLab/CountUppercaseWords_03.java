import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords_03 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        Predicate<String> isUpperCase = e -> Character.isUpperCase(e.charAt(0));

        List<String> words = Arrays.stream(input)
                .filter(isUpperCase)
                .collect(Collectors.toList());

        System.out.println(words.size());
        words.forEach(e -> System.out.println(e));

    }
}
