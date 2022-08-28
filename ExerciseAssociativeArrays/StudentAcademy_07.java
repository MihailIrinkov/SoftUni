import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentAcademy_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Double> studentData = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!studentData.containsKey(name)) {
                studentData.put(name, grade);
            } else {
                double average = (studentData.get(name) + grade) / 2;
                studentData.put(name, average);
//                studentData.get(name).add(average);
            }


        }

        studentData.entrySet().stream().filter(entry -> entry.getValue() > 4.49)
                .forEach(entry -> {
                    System.out.printf("%s -> %.2f%n", entry.getKey(), entry.getValue());
                });
    }
}
