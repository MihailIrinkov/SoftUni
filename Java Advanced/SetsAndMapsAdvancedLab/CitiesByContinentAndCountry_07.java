import java.util.*;

public class CitiesByContinentAndCountry_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, List<String>>> continents = new LinkedHashMap<>();

        while (num != 0) {

            String input = scanner.nextLine();

            String continent = input.split(" ")[0];
            String country = input.split(" ")[1];
            String city = input.split(" ")[2];


            continents.putIfAbsent(continent, new LinkedHashMap<>());

            LinkedHashMap<String, List<String>> countries = continents.get(continent);
            countries.putIfAbsent(country, new ArrayList<>());

            List<String> cities = countries.get(country);

            cities.add(city);


            num--;
        }

        continents.entrySet().stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ":");
                    entry.getValue().entrySet().stream()
                            .forEach(entryInside -> {
                                String cities = String.join(", ",  entryInside.getValue());
                                System.out.println("  " + entryInside.getKey() + " -> " + cities);

                            });

                });

    }
}
