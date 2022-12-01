package SpeedRacing_03_01;

import SpeedRacing_03.Car;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car_01> carMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String modelInput = input[0];
            double fuelAmountInput = Double.parseDouble(input[1]);
            double fuelCostPer1KmInput = Double.parseDouble(input[2]);
            Car_01 car_01 = new Car_01(modelInput, fuelAmountInput, fuelCostPer1KmInput);

            carMap.put(modelInput, car_01);
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            String currentModel = command.split("\\s+")[1];
            int amountOfKm = Integer.parseInt(command.split("\\s+")[2]);

            Car_01 askedCar = carMap.get(currentModel);

            if (askedCar.getFuelAmount() >= amountOfKm * askedCar.getFuelCostPer1Km()) {
                askedCar.setFuelAmount((askedCar.getFuelAmount()) - (amountOfKm * askedCar.getFuelCostPer1Km()));
                askedCar.setDistanceTraveled(askedCar.getDistanceTraveled() + amountOfKm);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }
            command = scanner.nextLine();
        }
        carMap.entrySet().forEach(e -> System.out.printf("%s %.2f %d%n", e.getValue().getModel(), e.getValue().getFuelAmount(), e.getValue().getDistanceTraveled())

        );

    }
}
