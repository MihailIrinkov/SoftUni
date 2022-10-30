import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> mapSymbols = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char currentSymbol = input.charAt(i);

            mapSymbols.putIfAbsent(currentSymbol, 0);
            int currentOccurrence = mapSymbols.get(currentSymbol);
            mapSymbols.put(currentSymbol, currentOccurrence + 1);
        }

        mapSymbols.entrySet().stream().forEach(e ->
        {
            System.out.printf("%s: %d time/s%n", e.getKey(), e.getValue());
        });

    }
}
