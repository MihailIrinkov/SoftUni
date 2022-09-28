import java.util.Scanner;

public class BackIn30Minutes_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
           int time = (hours * 60) + minutes + 30;

        int hoursTotal = time / 60;
        int minutesTotal = time % 60;
        if (hoursTotal > 23) {
            hoursTotal = 0;
        }
        System.out.printf("%d:%02d", hoursTotal, minutesTotal);
    }
}
