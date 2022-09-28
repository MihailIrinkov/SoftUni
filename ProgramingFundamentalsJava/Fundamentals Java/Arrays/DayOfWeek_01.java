import java.util.Scanner;

public class DayOfWeek_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] days = new String[]{
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday",
                "Sunday",
        };

        int n = Integer.parseInt(scanner.nextLine());

        if (n <= 7 && n >= 1) {
            System.out.println(days[n - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
