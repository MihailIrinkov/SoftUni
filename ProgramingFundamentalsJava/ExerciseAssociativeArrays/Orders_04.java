import java.util.*;

public class Orders_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Double> productPrice = new LinkedHashMap<>();
        Map<String, Integer> productQuantity = new LinkedHashMap<>();

        while (!input.equals("buy")) {
            String product = input.split(" ")[0];
            double price = Double.parseDouble(input.split(" ")[1]);
            int qty = Integer.parseInt(input.split(" ")[2]);

            productPrice.put(product, price);

            if (!productQuantity.containsKey(product)) {

                productQuantity.put(product, qty);
            } else {
                int newQty = productQuantity.get(product) + qty;
                productQuantity.put(product, newQty);

                double currentPrice = productPrice.get(product);

                if (price != currentPrice) {
                    productPrice.put(product, currentPrice);
                }
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Double> entry : productPrice.entrySet()) {
            String productName = entry.getKey();
            double totalSum = entry.getValue() * productQuantity.get(productName);
            System.out.printf("%s -> %.2f%n", productName, totalSum);

        }

    }
}
