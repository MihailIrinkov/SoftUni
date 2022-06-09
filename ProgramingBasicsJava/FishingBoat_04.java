import java.util.Scanner;

public class FishingBoat_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int fisher = Integer.parseInt(scanner.nextLine());

        double priceBoat = 0;
        switch(season){
            case "Spring":
                priceBoat = 3000;
                break;
            case "Summer":
            case "Autumn":
                priceBoat = 4200;
    break;
            case "Winter":
        priceBoat = 2600;
        break;
        }

        if (fisher <= 6){
            priceBoat = priceBoat * 0.90;
        }else if (fisher <= 11){
            priceBoat = priceBoat * 0.85;
        } else if(fisher > 12){
            priceBoat = priceBoat * 0.75;
        }

        if(fisher %2 == 0 && !season.equals("Autumn")){
            priceBoat = priceBoat * 0.95;
        }
        double diff = Math.abs(priceBoat - budget);
        if (budget >= priceBoat){
            System.out.printf("Yes! You have %.2f leva left.", diff);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", diff);}

    }

}
