import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String regex = ">>(?<furnitureName>[A-Za-z]+)<<(?<price>[0-9]+.?[0-9]*)!(?<quantity>[0-9]+)";

        Pattern pattern = Pattern.compile(regex);

        List<String> furnitureList = new ArrayList<>();
        double priceTotal = 0;

        while (!input.equals("Purchase")) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String furnitureName = matcher.group("furnitureName");
                double price = Double.parseDouble(matcher.group("price"));
                int qty = Integer.parseInt(matcher.group("quantity"));
                double priceT = price * qty;
                priceTotal += priceT;
                furnitureList.add(furnitureName);
            }
            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String f : furnitureList) {
            System.out.println(f);
        }
        System.out.printf("Total money spend: %.2f", priceTotal);

    }
}
