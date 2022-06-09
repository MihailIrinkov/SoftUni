import java.util.Scanner;

public class SumSecond_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int timeFirst = Integer.parseInt(scanner.nextLine());
        int timeSecond = Integer.parseInt(scanner.nextLine());
        int timeThird = Integer.parseInt(scanner.nextLine());
        int timeTotal = timeFirst + timeSecond + timeThird;
        int min = timeTotal / 60;
        int sec = timeTotal % 60;

            System.out.printf("%d:%02d", min, sec);
    }
}
