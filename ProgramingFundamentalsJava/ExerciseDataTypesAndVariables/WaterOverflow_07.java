import java.util.Scanner;

public class WaterOverflow_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        byte n = Byte.parseByte(scanner.nextLine());
        int watterTotal = 0;

        for (int i = 0; i < n; i++) {
            short watter = Short.parseShort(scanner.nextLine());
            if ((watterTotal + watter) <= 255) {
                watterTotal = watterTotal + watter;
            } else {
                System.out.println("Insufficient capacity!");

            }


        }
        System.out.println(watterTotal);
    }
}
