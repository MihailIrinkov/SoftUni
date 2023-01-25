package TrafficLights_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] signals = scanner.nextLine().split("\\s+");

        List<TrafficLight> trafficLights = new ArrayList<>();

        for (String s : signals) {
            TrafficLight trafficLight = new TrafficLight(Color.valueOf(s));

            trafficLights.add(trafficLight);
        }

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {

            for (TrafficLight t : trafficLights) {
                t.changeColor();
            }

            for (TrafficLight t: trafficLights) {
                System.out.print(t.getColor() + " ");
            }
            System.out.println();
        }

    }
}
