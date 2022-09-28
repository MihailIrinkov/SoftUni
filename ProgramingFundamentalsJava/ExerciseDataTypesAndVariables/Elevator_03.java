import java.util.Scanner;

public class Elevator_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

        int courses = people / capacity;

        if (people % capacity == 0) {
            System.out.println(courses);
        } else {
            int coursesExtra = courses + 1;
            System.out.println(coursesExtra);
        }


    }
}
