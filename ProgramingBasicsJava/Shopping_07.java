import java.util.Scanner;

public class Shopping_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int videoCard = Integer.parseInt(scanner.nextLine());
        int procesors = Integer.parseInt(scanner.nextLine());
        int ram = Integer.parseInt(scanner.nextLine());
        int videoCardPrice = 250 * videoCard;
        double procesorsPrice = videoCardPrice * 0.35;
        double procesorsPriceTotal = procesorsPrice * procesors;
        double ramPrice = videoCardPrice * 0.1;
        double ramPriceTotal = ramPrice * ram;
        double sumTotal = videoCardPrice + procesorsPriceTotal + ramPriceTotal;
        if(videoCard > procesors){
            sumTotal = sumTotal - (sumTotal * 0.15);
        }
if (budget >= sumTotal){
    double diff = budget - sumTotal;
    System.out.printf("You have %.2f leva left!", diff);
} else{
    double diffneed = sumTotal - budget;
    System.out.printf("Not enough money! You need %.02f leva more!", diffneed);
}
    }
}
