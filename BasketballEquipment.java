import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tax = Integer.parseInt(scanner.nextLine());
        double shoes = tax * 0.60;
        double suit = shoes - (shoes * 0.20);
        double ball = suit * 0.25;
        double acc = ball * 0.20;
        double sumAll = tax + shoes + suit + ball + acc;
        System.out.println(sumAll);
    }


}
