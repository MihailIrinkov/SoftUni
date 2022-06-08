import java.util.Scanner;

public class WeekendOrWorkingDay_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String weekday = scanner.nextLine();
        switch (weekday){
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                System.out.println("Working day");
                break;
            case "Saturday":
            case "Sunday":
                System.out.println("Weekend");
                break;
            default:
                System.out.println("Error");
                break;

        }
    }
}
