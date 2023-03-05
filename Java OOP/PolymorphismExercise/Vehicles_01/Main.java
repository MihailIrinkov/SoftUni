package Vehicles_01;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicles> map = new LinkedHashMap<>();

        map.put("Car", getVehicle(scanner));
        map.put("Truck", getVehicle(scanner));

//        String[] inputTruck = scanner.nextLine().split(" ");
//        double fuelQtyT = Double.parseDouble(inputTruck[1]);
//        double litersPerKmT = Double.parseDouble(inputTruck[2]);
//        Vehicles truck = new Truck(fuelQtyT, litersPerKmT);
//        map.put("Truck", truck);


        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
            String action = command[0];
            switch (action) {
                case "Drive":
//                    if(command[1].equals("Car")) {
//                        car.setFuelConsumption(car.getFuelConsumption());
//                       // car.drive(Double.parseDouble(command[2]));
//                        System.out.println(car.drive(Double.parseDouble(command[2])));
//                    } else {
//                        truck.setFuelConsumption(truck.getFuelConsumption());
//                       // truck.drive(Double.parseDouble(command[2]));
//                        System.out.println(truck.drive(Double.parseDouble(command[2])));
//                    }

                    System.out.println(map.get(command[1]).drive(Double.parseDouble(command[2])));

                    break;
                case "Refuel":
//                    if(command[1].equals("Car")) {
//                        car.refuel(Double.parseDouble(command[2]));
//
//                    } else {
//                        truck.refuel(Double.parseDouble(command[2]));
//                    }
                    map.get(command[1]).refuel(Double.parseDouble(command[2]));
                    break;
            }

        }
        map.values().forEach(System.out::println);
    }

    private static Vehicles getVehicle(Scanner scanner) {
        String[] inputCar = scanner.nextLine().split("\\s+");
        System.out.println();
        double fuelQty = Double.parseDouble(inputCar[1]);
        double litersPerKm = Double.parseDouble(inputCar[2]);
        String type = inputCar[0];

        switch (type) {
            case "Car":
                return new Car(fuelQty, litersPerKm);
            case "Truck":
                return new Truck(fuelQty, litersPerKm);
            default:
                throw new IllegalArgumentException("Missing car");
        }

    }
}
