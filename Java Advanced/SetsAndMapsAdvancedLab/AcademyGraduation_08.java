import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation_08 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        Map<String, Double> map = new TreeMap<>();

        while (num-- > 0) {
            String name = scanner.nextLine();
            double[] grade = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            double averageGrade = Arrays.stream(grade).average().getAsDouble();

            map.put(name, averageGrade);

        }

        map.entrySet().stream()
                .forEach(e -> {
                    System.out.printf("%s is graduated with %.2f%n", e.getKey(), e.getValue());
                });

    }
}
