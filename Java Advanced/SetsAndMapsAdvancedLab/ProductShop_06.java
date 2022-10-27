import java.util.*;

public class ProductShop_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        Map<String, Map<String, Double>> shops = new TreeMap<>();

        while (!command.equals("Revision")) {
            String shopName = command.split(", ")[0];
            String productName = command.split(", ")[1];
            double price = Double.parseDouble(command.split(", ")[2]);

            shops.putIfAbsent(shopName, new LinkedHashMap<>());

            Map<String, Double> products = shops.get(shopName);
            products.putIfAbsent(productName, price);
//            List<Double> productPrice = products.get(productName);
//            productPrice.add(price);

//            shops.get(shopName).put(productName, new ArrayList<>());
//
//            List<String> productPrice = new ArrayList<>();
//            productPrice.add(price);


            command = scanner.nextLine();
        }

        shops.entrySet().stream()
                //.sorted(Map.Entry.comparingByKey())

                .forEach(entry -> {
                    System.out.println(entry.getKey() + "->");

                    entry.getValue().entrySet().stream().forEach(entryInside -> {
                        System.out.printf("Product: %s, Price: %.1f%n", entryInside.getKey(), entryInside.getValue());
                        //String p = String.join(":",  entryInside.getValue());

                    });
                });

    }
}
