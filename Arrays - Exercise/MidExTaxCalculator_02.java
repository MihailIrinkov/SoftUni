import java.util.Scanner;

import static java.util.Arrays.stream;

public class MidExTaxCalculator_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] taxedVehicle = scanner.nextLine().split(">>");
        double taxTotal = 0;
        for (int i = 0; i <= taxedVehicle.length -1; i++) {
            String currentV = taxedVehicle[i];
           String[] input = currentV.split(" ");
            //for (int j = 0; j <= input.length - 1; j++) {
                if (input[0].equals("family")) {
                    String carType = input[0];
                    int travKm = Integer.parseInt(input[2]);
                    int yearsInUse = Integer.parseInt(input[1]);
                    double taxToPay = travKm / 3000 * 12 + (50 - yearsInUse * 5);
                    System.out.printf("A %s car will pay %.2f euros in taxes.%n", carType, taxToPay);
                    taxTotal += taxToPay;
                } else if (input[0].equals("heavyDuty")) {
                    String carType = input[0];
                    int travKm = Integer.parseInt(input[2]);
                    int yearsInUse = Integer.parseInt(input[1]);
                    double taxToPay = travKm / 9000 * 14 + (80 - yearsInUse * 8);
                    System.out.printf("A %s car will pay %.2f euros in taxes.%n", carType, taxToPay);
                    taxTotal += taxToPay;

                } else if (input[0].equals("sports")) {
                    String carType = input[0];
                    int travKm = Integer.parseInt(input[2]);
                    int yearsInUse = Integer.parseInt(input[1]);
                    double taxToPay = travKm / 2000 * 18 + (100 - yearsInUse * 9);
                    System.out.printf("A %s car will pay %.2f euros in taxes.%n", carType, taxToPay);
                    taxTotal += taxToPay;

                } else {
                    System.out.println("Invalid car type.");
                }
            // }

        }

        System.out.printf("The National Revenue Agency will collect %.2f euros in taxes.", taxTotal);
    }
}
