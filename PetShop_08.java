import java.util.Scanner;

public class PetShop_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dogCount = Integer.parseInt(scanner.nextLine());
        int catCount = Integer.parseInt(scanner.nextLine());
        double dogFoodPrice = 2.5;
        int catFoodPricel = 4;

        double sum = (dogCount * dogFoodPrice) + (catCount * catFoodPricel);

                System.out.println(sum + " lv.");
    }
}
