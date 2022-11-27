package CarInfo_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> data = new ArrayList<>();

        String input = scanner.nextLine();

        for (int i = 0; i < n; i++) {

            String brand = input.split("\\s+")[0];
            String model = input.split("\\s+")[1];
            int horseP = Integer.parseInt(input.split("\\s+")[2]);

            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horseP);

            data.add(car);

            input = scanner.nextLine();
        }

        data.forEach(e -> System.out.println(e.carInfo()));
    }
}
