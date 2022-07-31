import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students_05 {

    static class Student {
        String firstName;
        String lastName;
        String age;
        String town;

        public Student(String firstName, String lastName, String age, String town) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.town = town;
        }

        public String getFirstName() {
            return this.firstName;
        }

        public String getLastName() {
            return this.lastName;
        }

        public String getAge() {
            return this.age;
        }

        public String getTown() {
            return this.town;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String[] dataArr = command.split(" ");
            String firstName = dataArr[0];
            String lastName = dataArr[1];
            String age = dataArr[2];
            String town = dataArr[3];

            Student currentStudent = new Student(firstName, lastName, age, town);
            studentList.add(currentStudent);
            command = scanner.nextLine();
        }
        String searchTown = scanner.nextLine();

        for (Student item : studentList) {
            if (item.getTown().equals(searchTown)) {
                System.out.printf("%s %s is %s years old%n",
                        item.getFirstName(),
                        item.getLastName(),
                        item.getAge());
            }
            
        }

    }
}
