import java.util.*;

public class AverageStudentsGrades_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudent = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new TreeMap<>();

        while (countStudent -- > 0) {

            String input = scanner.nextLine();

            String studentName = input.split("\\s+")[0];
            Double grade = Double.parseDouble(input.split("\\s+")[1]);

            if (!students.containsKey(studentName)) {
                students.put(studentName, new ArrayList<>());
                List<Double> studentsGrads = students.get(studentName);
                studentsGrads.add(grade);
            } else {
                students.get(studentName).add(grade);
            }

        }

        students.entrySet().stream().forEach( entry -> {
                    System.out.print(entry.getKey() + " -> ");
            int count = 0;
            double sum = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {

                double currentGrade = entry.getValue().get(i);
                System.out.printf("%.2f ", currentGrade);
                sum += entry.getValue().get(i);
                count++;
            }
            System.out.printf("(avg: %.2f)%n", sum / count);






                }

        );


    }
}
