import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            List<String> input = Arrays.stream(command.split(" "))
                    .collect(Collectors.toList());
            String firstCommand = input.get(0);
            int secondCommand = Integer.parseInt(input.get(1));
            if (firstCommand.equals("Delete")) {
                list.removeAll(Arrays.asList(secondCommand));
            } else if (firstCommand.equals("Insert")) {
                int thirdCommand = Integer.parseInt(input.get(2));
                list.add(thirdCommand, secondCommand);
            }

            command = scanner.nextLine();
        }
        for (int num : list) {
            System.out.print(num + " ");
        }
    }
}
