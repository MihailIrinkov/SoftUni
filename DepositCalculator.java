import java.sql.SQLOutput;
import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double deposit = Double.parseDouble(scanner.nextLine());
        int months = Integer.parseInt(scanner.nextLine());
        Double interestpercent = Double.parseDouble(scanner.nextLine());

        Double interest = deposit * interestpercent / 100;
        Double interestMounth = interest / 12;

        Double sum = deposit + months * interestMounth;
        System.out.println(sum);
    }
}
