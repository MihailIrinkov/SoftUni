import java.util.Scanner;

public class Orders_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ordersCount = Integer.parseInt(scanner.nextLine());
double totalPrice = 0;
        for (int i = 1; i <= ordersCount; i++) {
            double capsulePrice = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());
            double priceOrder = capsulePrice * days * capsulesCount;
            totalPrice += priceOrder;
            System.out.printf("The price for the coffee is: $%.2f", priceOrder);
            System.out.println();
        }

        System.out.printf("Total: $%.2f", totalPrice);

    }
}
