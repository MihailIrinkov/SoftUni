import java.util.Scanner;

public class MultiplicationTable2_0_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());
        int times = Integer.parseInt(scanner.nextLine());

         if (times > 10) {
             int product = times * num;
             System.out.printf("%d X %d = %d%n", num, times, product);
         } else {
        for (int i = times; i <= 10; i++) {
            int product = i * num;
            System.out.printf("%d X %d = %d%n", num, i, product);}
        }
    }
}
