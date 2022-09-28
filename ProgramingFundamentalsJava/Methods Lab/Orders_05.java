import java.util.Scanner;

public class Orders_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        orderPrice(input, quantity);

    }

    public static void orderPrice(String product, int quantity) {
        switch (product) {
            case "coffee":
                double price = quantity * 1.50;
                System.out.printf("%.2f", price);
                break;
            case "water":
                double priceW = quantity * 1.00;
                System.out.printf("%.2f", priceW);
                break;
            case "coke":
                double priceC = quantity * 1.40;
                System.out.printf("%.2f", priceC);
                break;
            case "snacks":
                double priceS = quantity * 2.00;
                System.out.printf("%.2f", priceS);
                break;
        }
    }
}
