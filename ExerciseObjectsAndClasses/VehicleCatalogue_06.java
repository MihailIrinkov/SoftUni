import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue_06 {
    public static class Vehicle {
        private String type;
        private String model;
        private String color;
        private int hp;

        public Vehicle(String type, String model, String color, int hp) {
            this.type = type;
            this.model = model;
            this.color = color;
            this.hp = hp;
        }

        public String getType() {
            return this.type;
        }

        public String getModel() {
            return this.model;
        }

        public String getColor() {
            return this.color;
        }

        public int getHp() {
            return this.hp;
        }

        @Override
        public String toString() {
            String formattedType = "";
            if (getType().equals("car")) {
                formattedType = "Car";
            } else if (getType().equals("truck")) {
                formattedType = "Truck";
            }
            return String.format("Type: %s%nModel: %s%nColor: %s%nHorsepower: %d", formattedType, this.model, this.color, this.hp);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        List<Vehicle> vehicleList = new ArrayList<>();

        while (!command.equals("End")) {
            String[] input = command.split(" ");
            String type = input[0];
            String model = input[1];
            String color = input[2];
            int hp = Integer.parseInt(input[3]);
            Vehicle vehicle = new Vehicle(type, model, color, hp);
            vehicleList.add(vehicle);

            command = scanner.nextLine();
        }

        String modelsOfVehicle = scanner.nextLine();

        while (!modelsOfVehicle.equals("Close the Catalogue")) {
            for (Vehicle vehicle : vehicleList) {
                if (modelsOfVehicle.equals(vehicle.getModel())) {
                    System.out.println(vehicle.toString());
                    break;
                }
            }

            modelsOfVehicle = scanner.nextLine();
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", averageHp(vehicleList, "cars"));
        System.out.printf("Trucks have average horsepower of: %.2f.", averageHp(vehicleList, "trucks"));

    }

    private static double averageHp(List<Vehicle> vehicleList, String type) {
        int count = 0;
        double horsePower = 0;
        if (type.equals("cars")) {
            for (Vehicle vehicle : vehicleList) {
                if (vehicle.getType().equals("car")) {
                    count++;
                    horsePower += vehicle.getHp();
                }
            }
        } else if (type.equals("trucks")) {
            for (Vehicle vehicle : vehicleList) {
                if (vehicle.getType().equals("truck")) {
                    count++;
                    horsePower += vehicle.getHp();
                }
            }
        }

        if (horsePower == 0) {
            return 0;
        } else {
            return horsePower / count;
        }
    }
}
