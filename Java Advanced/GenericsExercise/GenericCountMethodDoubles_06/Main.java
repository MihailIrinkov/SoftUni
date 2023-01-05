package GenericCountMethodDoubles_06;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Box<Double> box = new Box<>();

        for (int i = 0; i < n; i++) {
            double num = Double.parseDouble(scanner.nextLine());

            box.add(num);
        }

        double elementToCompare = Double.parseDouble(scanner.nextLine());

        System.out.println(box.compare(elementToCompare));
    }
}
