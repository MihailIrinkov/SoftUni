import java.util.*;

public class CountRealNumbers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] values = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> occurrence = new LinkedHashMap<>();

        for (double d : values) {
            if (!occurrence.containsKey(d)) {
                occurrence.put(d, 1);
            } else {
                occurrence.put(d, occurrence.get(d) + 1);
            }
        }

        for (Double key : occurrence.keySet()) {
            System.out.printf("%.1f -> %d%n", key, occurrence.get(key));
        }

    }
}
