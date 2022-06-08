import java.util.Scanner;

public class WorkingHours_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int time = Integer.parseInt(scanner.nextLine());
        String day = scanner.nextLine();
        if (time < 10 || time > 18){
            System.out.println("closed");
        }
        else if (time >= 10 || time <= 18) {

        switch (day) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
            case "Saturday":
                System.out.println("open");
                break;


            default:
                System.out.println("closed");
        }

        }
    }
}

