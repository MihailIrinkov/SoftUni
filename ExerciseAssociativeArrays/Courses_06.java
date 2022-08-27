import java.util.*;

public class Courses_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("end")) {
            String courseName = input.split(" : ")[0];
            String studentName = input.split(" : ")[1];

            if (!courses.containsKey(courseName)) {
                List<String> currentStudent = new ArrayList<>();
                currentStudent.add(studentName);
                courses.put(courseName, currentStudent);
            } else {
//                List<String> currentStudent = new ArrayList<>();
//                currentStudent.add(studentName);
                courses.get(courseName).add(studentName);
            }

            input = scanner.nextLine();
        }
        courses.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + ": " + entry.getValue().size());
            entry.getValue().forEach(studentName -> System.out.println("-- " + studentName));
        });
    }
}
