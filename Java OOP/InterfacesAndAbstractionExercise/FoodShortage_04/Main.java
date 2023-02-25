package FoodShortage_04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Citizen> citizens = new ArrayList<>();
        List<Rebel> rebels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            if (input.length == 4) {
                citizens.add(new Citizen(input[0], Integer.parseInt(input[1]),
                        input[2], input[3]));
            } else {
                rebels.add(new Rebel(input[0], Integer.parseInt(input[1]), input[2]));
            }
        }

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            String name = command;

            citizens.stream().filter(c -> c.getName().equals(name)).findFirst()
                    .ifPresent(c -> c.buyFood());

            rebels.stream().filter(r ->r.getName().equals(name)).findFirst()
                    .ifPresent(r -> r.buyFood());

            command = scanner.nextLine();
        }

        //citizens.stream().map(c -> c.getFood()).reduce(0, (a,b) -> a+b);

        int sum = citizens.stream().mapToInt(Citizen::getFood).sum()
        +rebels.stream().mapToInt(Rebel::getFood).sum();

        System.out.println(sum);
    }
}
