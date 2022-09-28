import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int capacity = Integer.parseInt(scanner.nextLine());

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            if (command.contains("Add")) {
                int newPassengers = Integer.parseInt(command.split(" ")[1]);
                list.add(newPassengers);
            } else {
                int passanger = Integer.parseInt(command);
                for (int i = 0; i < list.size(); i++) {
                    int passInWagon = list.get(i);

                    if ((passInWagon + passanger) <= capacity) {
                        list.set(i, (passanger + passInWagon));
                        break;
                    }
                }

            }

            command = scanner.nextLine();
        }

        for (int num : list) {
            System.out.print(num + " ");
        }
    }

}
