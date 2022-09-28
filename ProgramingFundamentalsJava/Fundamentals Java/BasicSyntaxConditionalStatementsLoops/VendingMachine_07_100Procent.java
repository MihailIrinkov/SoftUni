import java.util.Scanner;

public class VendingMachine_07_100Procent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double sumCoins = 0;
        double purchaseSum = 0;
        double change = 0;
        String command = scanner.nextLine();

        while (!command.equals("Start")) {
            double insertCoin = Double.parseDouble(command);
            if (insertCoin == 0.1) {
                sumCoins += insertCoin;
            } else if (insertCoin == 0.2) {
                sumCoins += insertCoin;
            } else if (insertCoin == 0.5) {
                sumCoins += insertCoin;
            } else if (insertCoin == 1) {

                sumCoins += insertCoin;
            } else if (insertCoin == 2) {

                sumCoins += insertCoin;
            } else {
                System.out.printf("Cannot accept %.2f%n", insertCoin);
            }
            command = scanner.nextLine();
        }

        String purchaseProduct = scanner.nextLine();

        while (!purchaseProduct.equals("End")) {

            switch (purchaseProduct) {
                case "Nuts":
                    purchaseSum = 2.0;


                    if (sumCoins < purchaseSum) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.printf("Purchased %s%n", purchaseProduct);
                        sumCoins -= 2.0;
                    }
                    break;
                case "Water":
                    purchaseSum = 0.7;


                    if (sumCoins < purchaseSum) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.printf("Purchased %s%n", purchaseProduct);
                        sumCoins -= 0.7;
                    }
                    break;

                case "Crisps":
                    purchaseSum = 1.5;


                    if (sumCoins < purchaseSum) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.printf("Purchased %s%n", purchaseProduct);
                        sumCoins -= 1.5;
                    }
                    break;

                case "Soda":
                    purchaseSum = 0.8;


                    if (sumCoins < purchaseSum) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.printf("Purchased %s%n", purchaseProduct);
                        sumCoins -= 0.8;
                    }
                    break;

                case "Coke":
                    purchaseSum = 1.0;


                    if (sumCoins < 0) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        System.out.printf("Purchased %s%n", purchaseProduct);
                        sumCoins -= 1.0;
                    }
                    break;

                default:
                    System.out.println("Invalid product");


            }
            change = sumCoins;
            purchaseProduct = scanner.nextLine();

        }
        System.out.printf("Change: %.2f", change);
    }
}
