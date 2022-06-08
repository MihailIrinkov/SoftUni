import java.util.Scanner;

public class VacationBooksList_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pageNumber = Integer.parseInt(scanner.nextLine());
        int pagePerHour = Integer.parseInt(scanner.nextLine());
        int dayNumber = Integer.parseInt(scanner.nextLine());
        int totalTimeReading = pageNumber / pagePerHour;
        int hoursPerDay = totalTimeReading / dayNumber;
        System.out.println(hoursPerDay);
    }
}
