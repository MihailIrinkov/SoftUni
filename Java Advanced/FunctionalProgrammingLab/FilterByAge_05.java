import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> people = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(", ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            people.put(name, age);
        }

        String condition = scanner.nextLine();
        int conditionAge = Integer.parseInt(scanner.nextLine());
        String conditionFormat = scanner.nextLine();

        BiPredicate<Integer, Integer> filterPredicate;
        if (condition.equals("younger")) {
            filterPredicate = (age, ageCon) -> age <= ageCon;
        } else {
            filterPredicate = (age, ageCon) -> age >= ageCon;
        }

        Consumer<Map.Entry<String, Integer>> printConsumer;

        if (conditionFormat.equals("name")) {
            printConsumer = e -> System.out.println(e.getKey());
        } else if (conditionFormat.equals("age")) {
            printConsumer = e -> System.out.println(e.getValue());
        } else {
            printConsumer = e -> System.out.printf("%s - %d%n", e.getKey(), e.getValue());
        }

        people.entrySet().stream()
                .filter(e -> filterPredicate.test(e.getValue(), conditionAge))
                .forEach(printConsumer);


    }
}
