import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Set<String> carNumbers = new LinkedHashSet<>();

        while (!input.equals("END")) {


            String command = input.split(", ")[0];
            String carNumber = input.split(", ")[1];

            if (command.equals("IN")) {
                carNumbers.add(carNumber);
            } else {
                carNumbers.remove(carNumber);
            }
            input = scanner.nextLine();
        }

        if (carNumbers.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String s : carNumbers) {
                System.out.println(s);
            }
        }


//        String output = carNumbers.isEmpty() ? "Parking Lot is Empty"
//                : String.join(System.lineSeparator(), carNumbers);
//        System.out.println(output);
    }
}
