package CustomList_07;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        CustomList<String> list = new CustomList<>();

        while (!command.equals("END")) {

            String commandPart = command.split("\\s+")[0];

            switch (commandPart) {
                case "Add":
                    list.add(command.split("\\s+")[1]);
                    break;
                case "Remove":
                    list.remove(Integer.
                            parseInt(command.split("\\s+")[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(command.split("\\s+")[1]));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(command.split("\\s+")[1]);
                    int secondIndex = Integer.parseInt(command.split("\\s+")[2]);
                    list.swap(firstIndex, secondIndex);
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(command.split("\\s+")[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.print();
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
