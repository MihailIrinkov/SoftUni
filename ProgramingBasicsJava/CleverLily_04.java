import java.util.Scanner;

public class CleverLily_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = Integer.parseInt(scanner.nextLine());
        double washMachine = Double.parseDouble(scanner.nextLine());
        int priceToy = Integer.parseInt(scanner.nextLine());
        int countToys = 0;
        int money = 0;
        int sumMoney = 0;
        int countBro = 0;
        for (int i = 1; i <= age; i++) {
            if (i % 2 != 0){
                countToys ++;
            } else {
                countBro++;
                money = money + 10;
                sumMoney = sumMoney + money;
            }

        }
        double sumTotal = sumMoney + (priceToy * countToys) - (countBro * 1.00);
        double diff = Math.abs(washMachine - sumTotal);
        if (sumTotal >= washMachine){
            System.out.printf("Yes! %.2f", diff);
        } else {
            System.out.printf("No! %.2f", diff);
        }
    }
}