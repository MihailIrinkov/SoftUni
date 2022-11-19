import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetics_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        UnaryOperator<List<Integer>> add = e -> e.stream()
                .map(num -> num + 1).collect(Collectors.toList());
        UnaryOperator<List<Integer>> multiply = e -> e.stream()
                .map(num -> num * 2).collect(Collectors.toList());
        UnaryOperator<List<Integer>> subtract = e -> e.stream()
                .map(num -> num - 1).collect(Collectors.toList());
        Consumer<List<Integer>> print = e -> e.forEach(num -> System.out.print(num + " "));

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    list = add.apply(list);
                    break;

                case "multiply":
                    list = multiply.apply(list);
                    break;

                case "subtract":
                    list = subtract.apply(list);
                    break;

                case "print":
                    print.accept(list);
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
