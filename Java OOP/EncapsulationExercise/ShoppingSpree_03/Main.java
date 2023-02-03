package ShoppingSpree_03;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] personInput = scanner.nextLine().split(";");
        String[] productInput = scanner.nextLine().split(";");

        Map<String, Person> personMap = new LinkedHashMap<>();

        for (String personData : personInput) {
            String[] data = personData.split("=");
            String name = data[0];
            double money = Double.parseDouble(data[1]);

            try {
                Person person = new Person(name, money);
                personMap.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }

        }

        Map<String, Product> productMap = new LinkedHashMap<>();

        for (String productData : productInput) {
            String[] data = productData.split("=");
            String name = data[0];
            double cost = Double.parseDouble(data[1]);

            try {
                Product product = new Product(name, cost);
                productMap.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("END")) {

            String[] input = command.split(" ");

            String personName = input[0];
            String productName = input[1];

            Person person = personMap.get(personName);
            Product product = productMap.get(productName);

            try {
                person.buyProduct(product);
                System.out.printf("%s bought %s%n", personName, productName);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }

            command = scanner.nextLine();
        }

          personMap.values().forEach(p -> System.out.println(p.toString()));

    }
}
