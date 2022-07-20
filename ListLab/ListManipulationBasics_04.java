import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numList = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("end")) {
            List<String> commandLine = Arrays.stream(input.split(" "))
                    .collect(Collectors.toList());
            int item = 0;
            int index = 0;
            String command = commandLine.get(0);
            switch (command) {
                case "Add":
                    item = Integer.parseInt(commandLine.get(1));
                    numList.add(item);
                    break;
                case "Remove":
                    item = Integer.parseInt(commandLine.get(1));
                    numList.remove(Integer.valueOf(item));
                    break;
                case "RemoveAt":
                    index = Integer.parseInt(commandLine.get(1));
                    numList.remove(index);
                    break;
                case "Insert":
                    item = Integer.parseInt(commandLine.get(1));
                    index = Integer.parseInt(commandLine.get(2));
                    numList.add(index, item);
                    break;
            }
            input = scanner.nextLine();
        }

        //for (int num : numList) {
        //   System.out.print(num + " ");
        //}
        System.out.println(numList.toString().replaceAll("[\\[\\],]", ""));
    }
}
