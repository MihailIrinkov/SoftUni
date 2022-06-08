import java.util.Scanner;

public class YardGreening_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double yardSize = Double.parseDouble(scanner.nextLine());
        Double yardPrice = yardSize * 7.61;
                Double discount = yardPrice * 0.18;
                double finalPrice = yardPrice - discount;
        System.out.println("The final price is: " + finalPrice + " lv.");
        System.out.println("The discount is: " + discount + " lv.");

    }
}
