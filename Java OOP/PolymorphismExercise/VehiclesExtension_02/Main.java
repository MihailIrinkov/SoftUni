package VehiclesExtension_02;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicles> map = new LinkedHashMap<>();

        map.put("Car", getVehicle(scanner));
        map.put("Truck", getVehicle(scanner));
        map.put("Bus", getVehicle(scanner));

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
            String action = command[0];
            switch (action) {
                case "DriveEmpty":
                    System.out.println(map.get(command[1]).drive(Double.parseDouble(command[2])));
                    break;
                case "Drive":
                    System.out.println(map.get(command[1]).driveWithAc(Double.parseDouble(command[2])));
                    break;
                case "Refuel":
                    try {
                        map.get(command[1]).refuel(Double.parseDouble(command[2]));
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
            }

        }
        map.values().forEach(System.out::println);
    }

    private static Vehicles getVehicle(Scanner scanner) {
        String[] inputCar = scanner.nextLine().split("\\s+");
        System.out.println();
        double fuelQty = Double.parseDouble(inputCar[1]);
        double litersPerKm = Double.parseDouble(inputCar[2]);
        double tankCapacity = Double.parseDouble(inputCar[3]);
        String type = inputCar[0];

        switch (type) {
            case "Car":
                return new Car(fuelQty, litersPerKm, tankCapacity);
            case "Truck":
                return new Truck(fuelQty, litersPerKm, tankCapacity);
            case "Bus":
                return new Bus(fuelQty, litersPerKm, tankCapacity);
            default:
                throw new IllegalArgumentException("Missing car");
        }

    }

}

