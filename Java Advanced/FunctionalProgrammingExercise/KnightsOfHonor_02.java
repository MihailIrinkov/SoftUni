import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class KnightsOfHonor_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine()
                .split(" ")).collect(Collectors.toList());

        Consumer<String> consumer = n -> System.out.println("Sir " + n);

        names.forEach(consumer);

    }
}
