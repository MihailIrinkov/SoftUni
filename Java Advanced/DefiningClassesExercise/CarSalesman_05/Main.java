package CarSalesman_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engineList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String modelIn = input[0];
            int powerIn = Integer.parseInt(input[1]);

            if (input.length == 2) {
                int displacementIn = 0;
                String efficiencyIn = "n/a";
                Engine engine = new Engine(displacementIn, efficiencyIn, modelIn, powerIn);
                engineList.add(engine);
            } else if (input.length == 3) {
                try {
                    int displacementIn = Integer.parseInt(input[2]);
                    String efficiencyIn = "n/a";
                    Engine engine = new Engine(displacementIn, efficiencyIn, modelIn, powerIn);
                    engineList.add(engine);
                } catch (NumberFormatException e) {
                    int displacementIn = 0;
                    String efficiencyIn = input[2];
                    Engine engine = new Engine(displacementIn, efficiencyIn, modelIn, powerIn);
                    engineList.add(engine);
                }
            } else if (input.length == 4) {
                int displacementIn = Integer.parseInt(input[2]);
                String efficiencyIn = input[3];
                Engine engine = new Engine(displacementIn, efficiencyIn, modelIn, powerIn);
                engineList.add(engine);
            }
        }
        int m = Integer.parseInt(scanner.nextLine());
        List<Car> carList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            if (input.length == 4) {
                String modelIn = input[0];
                String engineIn = input[1];
                int weightIn = Integer.parseInt(input[2]);
                String colorIn = input[3];
                int currentEngine = 0;

                for (int j = 0; j < engineList.size(); j++) {
                    Engine k = engineList.get(j);
                    if (k.getModel().equals(engineIn)) {
                        currentEngine = j;
                    }
                }

                Car car = new Car(modelIn, engineList.get(currentEngine), weightIn, colorIn);
                carList.add(car);
            } else if(input.length == 2){
                String modelIn = input[0];
                String engineIn = input[1];
                int weightIn = 0;
                String colorIn = "n/a";
                int currentEngine = 0;
                for (int j = 0; j < engineList.size(); j++) {
                    Engine k = engineList.get(j);
                    if (k.getModel().equals(engineIn)) {
                        currentEngine = j;
                    }
                }
                Car car = new Car(modelIn, engineList.get(currentEngine), weightIn, colorIn);
                carList.add(car);
            } else if (input.length == 3){
                try {
                    String modelIn = input[0];
                    String engineIn = input[1];
                    int weightIn = Integer.parseInt(input[2]);
                    String colorIn = "n/a";
                    int currentEngine = 0;
                    for (int j = 0; j < engineList.size(); j++) {
                        Engine k = engineList.get(j);
                        if (k.getModel().equals(engineIn)) {
                            currentEngine = j;
                        }
                    }
                    Car car = new Car(modelIn, engineList.get(currentEngine), weightIn, colorIn);
                    carList.add(car);
                } catch (NumberFormatException e) {
                    String modelIn = input[0];
                    String engineIn = input[1];
                    int weightIn = 0;
                    String colorIn = input[2];
                    int currentEngine = 0;
                    for (int j = 0; j < engineList.size(); j++) {
                        Engine k = engineList.get(j);
                        if (k.getModel().equals(engineIn)) {
                            currentEngine = j;
                        }
                    }
                    Car car = new Car(modelIn, engineList.get(currentEngine), weightIn, colorIn);
                    carList.add(car);
                }
            }
        }
        for (Car car : carList) {
            System.out.println(car.toString());
        }
    }
}
