import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String command = scanner.nextLine();

        while (!command.equals("end")) {
            List<String> input = Arrays.stream(command.split(" "))
                    .collect(Collectors.toList());
            String commandInput = input.get(0);
            String secondCommandLine = input.get(1);

            switch (commandInput) {
                case "Contains":
                    if (list.contains(Integer.parseInt(secondCommandLine))) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (secondCommandLine.equals("even")) {
                        for (int i = 0; i < list.size(); i++) {
                            int currentNum = list.get(i);
                            if (currentNum % 2 == 0) {
                                System.out.print(currentNum + " ");
                            }
                        }
                        System.out.println();
                    } else if (secondCommandLine.equals("odd")) {
                        for (int i = 0; i < list.size(); i++) {
                            int currentNum = list.get(i);
                            if (currentNum % 2 != 0) {
                                System.out.print(currentNum + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (int i = 0; i < list.size(); i++) {

                        int currentN = list.get(i);
                        sum += currentN;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    int thirdCommandLine = Integer.parseInt(input.get(2));
                    if (secondCommandLine.equals("<")) {
                        for (int i = 0; i < list.size(); i++) {
                            int currentNumber = list.get(i);
                            if (currentNumber < thirdCommandLine) {
                                System.out.print(currentNumber + " ");
                            }
                        }
                        System.out.println();
                    } else if (secondCommandLine.equals(">")) {
                        for (int i = 0; i < list.size(); i++) {
                            int currentNumber = list.get(i);
                            if (currentNumber > thirdCommandLine) {
                                System.out.print(currentNumber + " ");
                            }
                        }
                        System.out.println();
                    } else if (secondCommandLine.equals(">=")) {
                        for (int i = 0; i < list.size(); i++) {
                            int currentNumber = list.get(i);
                            if (currentNumber >= thirdCommandLine) {
                                System.out.print(currentNumber + " ");
                            }
                        }
                        System.out.println();
                    } else if (secondCommandLine.equals("<=")) {
                        for (int i = 0; i < list.size(); i++) {
                            int currentNumber = list.get(i);
                            if (currentNumber <= thirdCommandLine) {
                                System.out.print(currentNumber + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
