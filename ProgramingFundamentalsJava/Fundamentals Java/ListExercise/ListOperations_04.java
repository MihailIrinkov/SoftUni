import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            if (command.contains("Add")) {
                int numToAdd = Integer.parseInt(command.split(" ")[1]);
                list.add(numToAdd);
            } else if (command.contains("Insert")) {
                int numToInsert = Integer.parseInt(command.split(" ")[1]);
                int index = Integer.parseInt(command.split(" ")[2]);
                if (isValid(index, list.size())) {
                    list.add(index, numToInsert);
                } else {
                    System.out.println("Invalid index");
                }

            } else if (command.contains("Remove")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                if (isValid(index, list.size())) {
                    list.remove(index);
                } else {
                    System.out.println("Invalid index");
                }

            } else if (command.contains("Shift left")) {
                int count = Integer.parseInt(command.split(" ")[2]);
                for (int i = 0; i < count; i++) {
                    int firstNum = list.get(0);
                    list.add(firstNum);
                    list.remove(0);

                }

            } else if (command.contains("Shift right")) {

                int countR = Integer.parseInt(command.split(" ")[2]);
                for (int i = 0; i < countR; i++) {
                    int lastNum = list.get(list.size() - 1);
                    list.add(0, lastNum);
                    list.remove(list.size() - 1);

                }

            }

            command = scanner.nextLine();

        }

        for (int num : list) {
            System.out.print(num + " ");
        }

    }


    public static boolean isValid(int index, int listLength) {
        return index >= 0 && index <= listLength - 1;
    }
}
