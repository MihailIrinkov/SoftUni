package CustomListSorter_08;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CustomList<String> list = new CustomList<>();

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String commandPart = command.split("\\s+")[0];

            switch (commandPart) {
                case "Add":
                    list.add(command.split("\\s+")[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(command.split("\\s+")[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(command.split("\\s+")[1]));
                    break;
                case "Swap":
                    int first = Integer.parseInt(command.split("\\s+")[1]);
                    int second = Integer.parseInt(command.split("\\s+")[2]);
                    list.swap(first, second);
                    break;
                case "Greater":
                    System.out.println(list.greater(command.split("\\s+")[1]));
                    break;
                case "Max":
                    System.out.println(list.max());
                    break;
                case "Min":
                    System.out.println(list.min());
                    break;
                case "Print":
                    list.print();
                    break;
                case "Sort":
                    list.sort();
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
