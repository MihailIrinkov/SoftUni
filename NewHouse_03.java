import java.util.Scanner;

public class NewHouse_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeFlower  = scanner.nextLine();
        int countFlowers   = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());
        double totalPrice = 0;
        switch(typeFlower) {
            case "Roses":
                totalPrice = countFlowers   * 5.0;
                if (countFlowers   > 80){
                    totalPrice = totalPrice * 0.90;
                }
                break;
            case "Dahlias":
                totalPrice = countFlowers   * 3.80;
                if (countFlowers   > 90){
                    totalPrice = totalPrice * 0.85;
                }
                break;
            case "Tulips":
                totalPrice = countFlowers   * 2.80;
                if (countFlowers   > 80){
                    totalPrice = totalPrice * 0.85;
                }
                break;
            case "Narcissus":
                totalPrice = countFlowers   * 3.0;
                if (countFlowers   < 120) {
                    totalPrice = totalPrice * 1.15;
                }
                break;
            case "Gladiolus":
                totalPrice = countFlowers   * 2.50;
                if (countFlowers   < 80){
                    totalPrice = totalPrice * 1.20;
                }
                break;
        }
double difference = Math.abs(budget - totalPrice);
        if (budget >= totalPrice){
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", countFlowers, typeFlower, difference);
        } else if (budget < totalPrice){
            System.out.printf("Not enough money, you need %.2f leva more.", difference);
        }
    }
}
