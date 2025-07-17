import java.util.Arrays;
import java.util.Scanner;

public class Trains_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] arrivals = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .sorted()
                .toArray();

        double[] departures = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Arrays.sort(departures);

        int platforms = 0;
        int maxPlatforms = 0;

        for (int i = 0, j = 0; i < arrivals.length;) {
            if (arrivals[i] < departures[j]) {
                platforms++;
                i++;

                maxPlatforms = platforms > maxPlatforms ? platforms : maxPlatforms;
            } else {
                platforms--;
                j++;
            }
        }

        System.out.println(maxPlatforms);
    }
}
