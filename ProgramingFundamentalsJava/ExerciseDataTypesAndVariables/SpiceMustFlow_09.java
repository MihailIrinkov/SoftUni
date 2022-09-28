import java.util.Scanner;

public class SpiceMustFlow_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int source = Integer.parseInt(scanner.nextLine());

        int day = 0;
        int dayRent = 0;

        while (source >= 100) {
            day++;
            dayRent = dayRent + (source - 26);
            source -= 10;
        }
        if (dayRent >= 26) {
            dayRent -= 26;
        }
        System.out.println(day);
        System.out.println(dayRent);
    }
}
