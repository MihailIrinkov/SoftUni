import java.util.Scanner;

public class SkiTrip_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int days = Integer.parseInt(scanner.nextLine());
        String typeRoom = scanner.nextLine();
        String note = scanner.nextLine();
        int nights = days - 1;
        double price =0;
        double priceTotal = 0;
        switch(typeRoom){
            case "room for one person":
                price = nights * 18.00;
                break;
            case "apartment":
                if (days < 10) {
                    price = nights * (25.00 * 0.70);
                } else if ( days >= 10 && days <= 15) {
                    price = nights * (25.00 * 0.65);
                } else if (days > 15) {
                    price = nights * (25.00 * 0.50);
                }
                break;
            case "president apartment":
                if (days < 10) {
                    price = nights * (35.00 * 0.90);
                } else if ( days >= 10 && days <= 15) {
                    price = nights * (35.00 * 0.85);
                } else if (days > 15) {
                    price = nights * (35.00 * 0.80);
                }
                break;
        }
if (note.equals("positive")){
    priceTotal = price * 1.25;
} else {
    priceTotal = price * 0.90;
}

        System.out.printf("%.2f",priceTotal);
    }
}
