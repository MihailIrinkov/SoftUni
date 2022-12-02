package RawData_04;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        //Map<String, Car> carMap = new LinkedHashMap<>();
        List<Car> carList = new ArrayList<>();
        //List<Tire> tires = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String modelIn = input[0];
            int engineSpeedIn = Integer.parseInt(input[1]);
            int enginePowerIn = Integer.parseInt(input[2]);
            int cargoWeightIn = Integer.parseInt(input[3]);
            String cargoType = input[4];
            double tire1Pressure = Double.parseDouble(input[5]);
            int tire1Age = Integer.parseInt(input[6]);
            Tire tire = new Tire(tire1Pressure, tire1Age);
            List<Tire> tires = new ArrayList<>();
            tires.add(tire);
            double tire2Pressure = Double.parseDouble(input[7]);
            int tire2Age = Integer.parseInt(input[8]);
            Tire tire2 = new Tire(tire2Pressure, tire2Age);
            tires.add(tire2);
            double tire3Pressure = Double.parseDouble(input[9]);
            int tire3Age = Integer.parseInt(input[10]);
            Tire tire3 = new Tire(tire3Pressure, tire3Age);
            tires.add(tire3);
            double tire4Pressure = Double.parseDouble(input[11]);
            int tire4Age = Integer.parseInt(input[12]);
            Tire tire4 = new Tire(tire4Pressure, tire4Age);
            tires.add(tire4);
            Engine engine = new Engine(engineSpeedIn, enginePowerIn);
            Cargo cargo = new Cargo(cargoType, cargoWeightIn);


            Car car = new Car(modelIn, engine, cargo, tires);
            carList.add(car);
            //carMap.put(modelIn, car);
            //tires.clear();
        }
        String command = scanner.nextLine();
        if (command.equals("fragile")) {
            carList.stream()
                    .filter(e -> e.getCargo().getCargo().equals("fragile"))
                    .filter(car -> car.getTires().stream().anyMatch(tire -> tire.getTirePressure() < 1))
                    .forEach(e -> System.out.println(e.getModel()));

        } else {
            carList.stream()
                    .filter(car -> car.getCargo().getCargo().equals("flamable"))
                    .filter(car -> car.getEngine().getEnginePower() > 250)
                    .forEach(car -> System.out.println(car.getModel()));


        }
    }
}
