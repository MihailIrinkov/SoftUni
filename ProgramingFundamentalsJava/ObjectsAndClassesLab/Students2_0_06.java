import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students2_0_06 {

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
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getAge() {
            return age;
        }

        public String getTown() {
            return town;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public void setTown(String town) {
            this.town = town;
        }

        @Override
        public String toString() {
            return String.format("%s %s is %s years old%n",
                    this.getFirstName(),
                    this.getLastName(),
                    this.getAge());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> studentsList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] inputLine = input.split(" ");
            String firstName = inputLine[0];
            String lastName = inputLine[1];
            String age = inputLine[2];
            String town = inputLine[3];

            Student student = new Student(firstName, lastName, age, town);

            int existingIndex = findStudentIndex(studentsList, student.getFirstName(), student.getLastName());
            if (existingIndex != - 1) {
                studentsList.get(existingIndex).setTown(student.town);
                studentsList.get(existingIndex).setAge(student.age);
            } else {
                studentsList.add(student);
            }

            input = scanner.nextLine();
        }

        String searchTownName = scanner.nextLine();

        for (Student student : studentsList) {
            if (student.getTown().equals(searchTownName)) {
                System.out.print(student);
            }
        }
    }

    static int findStudentIndex(List<Student> studentsList, String firstName, String lastName) {
        for (int i = 0; i < studentsList.size(); i++) {
            String firstNameList = studentsList.get(i).getFirstName();
            String lastNameList = studentsList.get(i).getLastName();

            if (firstNameList.equals(firstName) && lastNameList.equals(lastName)) {
                return i;
            }
        }

        return -1;
    }
}
