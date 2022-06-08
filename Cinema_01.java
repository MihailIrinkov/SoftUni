import java.util.Scanner;

public class Cinema_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        int line = Integer.parseInt(scanner.nextLine());
        int colums = Integer.parseInt(scanner.nextLine());
        double sum = 0;
       double price = 0;
        switch (type){
            case "Premiere":
                price = 12.0;
                break;
            case "Normal":
                price = 7.50;
                break;
            case "Discount":
                price = 5.0;
                break;

        }
        sum = price * line * colums;
        System.out.printf("%.2f", sum);

    }

}
