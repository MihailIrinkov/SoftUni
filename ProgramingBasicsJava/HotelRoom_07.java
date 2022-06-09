import java.util.Scanner;

public class HotelRoom_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        int countNights = Integer.parseInt(scanner.nextLine());
        double priceTotal = 0;
        double priceTotalAppart = 0;
        if (month.equals("May") || month.equals("October")){
            if(countNights > 7 && countNights <= 14){
                priceTotal = (countNights * 50) * 0.95;
            } else if(countNights > 14){
                priceTotal = (countNights * 50) * 0.70;
                priceTotalAppart = (countNights * 65) * 0.90;

            } else{
            priceTotal = countNights * 50;
            priceTotalAppart = countNights * 65;}
        } else if (month.equals("June") || month.equals("September ")){
            if (countNights > 14){
                priceTotal = (countNights * 75.20) * 0.80;
                priceTotalAppart = (countNights * 68.70) * 0.90;
            } else {
            priceTotal = countNights * 75.20;
            priceTotalAppart = countNights * 68.70;}
        } else if (month.equals("July") || month.equals("August")){
            if(countNights > 14){
                priceTotalAppart = (countNights * 77.00) * 0.90;
                priceTotal = countNights * 76.00;
            }else{
            priceTotal = countNights * 76.00;
            priceTotalAppart = countNights * 77.00;}
        }
        System.out.printf("Apartment: %.2f lv. %n", priceTotalAppart);
        System.out.printf("Studio: %.2f lv.", priceTotal);
    }
}
