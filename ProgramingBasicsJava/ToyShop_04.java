import java.util.Scanner;

public class ToyShop_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double priceTrip = Double.parseDouble(scanner.nextLine());
        int puzle = Integer.parseInt(scanner.nextLine());
        int speakingP = Integer.parseInt(scanner.nextLine());
        int bear = Integer.parseInt(scanner.nextLine());
        int minons = Integer.parseInt(scanner.nextLine());
        int trucks = Integer.parseInt(scanner.nextLine());

        double sum = (puzle * 2.60) + (speakingP * 3.00) + (bear * 4.10) + (minons * 8.20) + (trucks * 2.00);
        int countTyos = trucks + puzle + speakingP + bear + minons;
        if (countTyos >=50){

            sum = sum * 0.75;
        }
        sum = sum - (sum * 0.1);
        double diff = Math.abs(priceTrip - sum);
        if (sum >= priceTrip){
            System.out.printf("Yes! %.2f lv left.", diff);
        }
        else {
            System.out.printf("Not enough money! %.2f lv needed.", diff);
        }




            }
}










