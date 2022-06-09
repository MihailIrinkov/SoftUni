import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iniHour = Integer.parseInt(scanner.nextLine());
        int iniMin = Integer.parseInt(scanner.nextLine());

        int allMinutes = (iniHour * 60) + iniMin + 30;

        int hour = allMinutes / 60;
        int min = allMinutes % 60;

        if (hour > 23) {
            hour = 0;
        }
        System.out.printf("%d:%02d", hour, min);
    }
}
