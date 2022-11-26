import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        Set<String> filter = new HashSet<>();

        String command = scanner.nextLine();

        while (!command.equals("Print")) {

            String[] commandParts = command.split(";");
            String commandType = commandParts[0];
            String filterType = commandParts[1];
            String parameter = commandParts[2];

            if (commandType.equals("Add filter")) {
                filter.add(filterType + ";" + parameter);
            } else {
                filter.remove(filterType + ";" + parameter);
            }

            command = scanner.nextLine();
        }

        filter.forEach(e -> {
            Predicate<String> filterToApply = getPredicate(e);
            names.removeIf(filterToApply);
        });

        names.forEach(e -> System.out.print(e + " "));

    }

    private static Predicate<String> getPredicate(String filter) {
        String[] filterParts = filter.split(";");
        String filterType = filterParts[0];
        String filterParameter = filterParts[1];

        switch (filterType) {
            case "Starts with":
                return e -> e.startsWith(filterParameter);
            case "Ends with":
                return e -> e.endsWith(filterParameter);
            case "Length":
                return e -> e.length() == Integer.parseInt(filterParameter);
            case "Contains":
                return e -> e.contains(filterParameter);
        }
        return null;
    }
}
