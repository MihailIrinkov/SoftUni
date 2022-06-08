import java.util.Scanner;

public class FoodDelivery_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int chikenMenuNumber = Integer.parseInt(scanner.nextLine());
        int fishMenuNumber = Integer.parseInt(scanner.nextLine());
        int veganMenuNumber = Integer.parseInt(scanner.nextLine());
        double chikenMenuPrice = chikenMenuNumber * 10.35;
        double fishMenuPrice = fishMenuNumber * 12.40;
        double veganMenuPrice = veganMenuNumber * 8.15;
        double totalMenuPrice = chikenMenuPrice + fishMenuPrice + veganMenuPrice;
        double DesetPrice = totalMenuPrice * 0.20;
        double totalPriceOrder = totalMenuPrice + DesetPrice + 2.50;
        System.out.println(totalPriceOrder);
    }
}
