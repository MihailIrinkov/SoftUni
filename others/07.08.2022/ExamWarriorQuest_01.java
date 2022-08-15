import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ExamWarriorQuest_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String values = scanner.nextLine();

        List<String> input = Arrays.stream(values.split("")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("For Azeroth")) {


            if (command.equals("GladiatorStance")) {
                input = input.stream()
                        .map(String::toUpperCase)
                        .collect(Collectors.toList());

                for (String entry : input) {
                    System.out.print(entry);
                }

                System.out.println();
            } else if (command.equals("DefensiveStance")) {

                input = input.stream()
                        .map(String::toLowerCase)
                        .collect(Collectors.toList());

                for (String entry : input) {
                    System.out.print(entry);
                }
                System.out.println();
            } else if (command.contains("Dispel")) {

                int index = Integer.parseInt(command.split(" ")[1]);
                String replaceLetter = command.split(" ")[2];
//                String size = input.toString();

                if (index > 0 && index <= input.size()) {
                    input.set(index, replaceLetter);
                    System.out.println("Success!");
                } else {
                    System.out.println("Dispel too weak.");
                }

            } else if (command.contains("Target Change")) {
                String firstString = command.split(" ")[1];
                String secondString = command.split(" ")[2];

//                List<String> newListResult = new ArrayList<>();

                for (String first : input) {
                    input.add(first.replaceAll(firstString, secondString));
                }


            } else if (command.contains("Target Remove")) {
                String substring = command.split(" ")[2];
                if (input.contains(substring)) {
                    input.remove(substring);
                }

            } else {
                System.out.println("Command doesn't exist!");
            }


            command = scanner.nextLine();
        }
    }
}
