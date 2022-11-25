import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());


        String command = scanner.nextLine();

        Set<String> filter = new TreeSet<>();



        while (!command.equals("Party!")) {
            String commandType = command.split(" ")[0];
            String action = command.split(" ")[1];
            String criteria = command.split(" ")[2];

            Predicate<String> predicateStart = e -> {
                if (e.startsWith(criteria)) {
                }
                return true;
            };

            if (action.equals("double")) {

               List<String> doubleName;
                doubleName = (List<String>) guests.stream().filter(predicateStart);

                guests.add(doubleName.get(0));

            } else {
                guests.remove(action + " " + criteria);
            }
            command = scanner.nextLine();
        }
        System.out.println();
    }

    private static Predicate<String> getPredicate(String filter) {
        String[] filterParts = filter.split(" ");
        String filterType = filterParts[0];
        String filterParameter = filterParts[1];

        switch (filterType) {
            case "StartsWith":
                return e -> e.startsWith(filterParameter);
            case "EndsWith":
                return e -> e.endsWith(filterParameter);
            case "Length":
                return e -> e.length() == Integer.parseInt(filterParameter);
        }
        return null;
    }

}
