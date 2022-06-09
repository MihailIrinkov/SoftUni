import java.util.Scanner;

public class PadawanEquipment_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double amountMoney = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double lightSaber = Double.parseDouble(scanner.nextLine());
        double robe = Double.parseDouble(scanner.nextLine());
        double belt = Double.parseDouble(scanner.nextLine());

        double priceLightSaber = Math.ceil(students * 1.1) * lightSaber;
        double priceRobe = robe * students;
        double priceBelt = belt * (students - (students / 6));
        double neededMoney = priceLightSaber + priceRobe + priceBelt;

        if (neededMoney <= amountMoney) {
            System.out.printf("The money is enough - it would cost %.2flv.", neededMoney);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", neededMoney - amountMoney);
        }

    }
}
