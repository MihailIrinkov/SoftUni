import java.util.Scanner;

public class SuppliesforSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int penPakege = Integer.parseInt(scanner.nextLine());
        int markersPakage = Integer.parseInt(scanner.nextLine());
        int chemieLiters = Integer.parseInt(scanner.nextLine());
        int percent = Integer.parseInt(scanner.nextLine());
//        •	Пакет химикали - 5.80 лв.
//•	Пакет маркери - 7.20 лв.
//•	Препарат - 1.20 лв (за литър)
        Double penPrice = penPakege * 5.80;
        Double priceMarkers = markersPakage * 7.20;
        Double priceChemie = chemieLiters * 1.20;
        Double priceTotal = penPrice + priceMarkers + priceChemie;
        Double priceWithDiscount = priceTotal - priceTotal * (percent / 100.0);
        System.out.println(priceWithDiscount);

    }
}
