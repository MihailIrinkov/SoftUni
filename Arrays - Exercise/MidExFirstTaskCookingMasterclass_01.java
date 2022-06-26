import java.util.Scanner;

public class MidExFirstTaskCookingMasterclass_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        byte students = Byte.parseByte(scanner.nextLine());
        double pricePackageFlour = Double.parseDouble(scanner.next());
        double priceSingleEgg = Double.parseDouble(scanner.next());
        double priceSingleApron = Double.parseDouble(scanner.next());

        double priceFlourTotal = (students - students / 5) * pricePackageFlour;
        double priceEggTotal = students * 10 * priceSingleEgg;
        double priceApronTotal = Math.ceil(students + 0.2 * students) * priceSingleApron;

        double neededMoney = priceFlourTotal + priceEggTotal + priceApronTotal;

        if (budget >= neededMoney) {
            System.out.printf("Items purchased for %.2f$.", neededMoney);
        } else {
            System.out.printf("%.2f$ more needed.", neededMoney - budget);
        }

    }
}
