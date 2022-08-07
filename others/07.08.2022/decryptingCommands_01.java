import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class decryptingCommands_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = Arrays.stream(scanner.nextLine().split(""))
                .collect(Collectors.toList());
        String command = scanner.nextLine();


        while (!command.equals("Finish")) {
            if (command.length() >= 1) {
                String toDo = command.split(" ")[0];
                switch (toDo) {
                    case "Replace":
                        String currentChar = command.split(" ")[1];
                        String newChar = command.split(" ")[2];

                        for (int i = 0; i < input.size(); i++) {
                            String ch = input.get(i);

                            if (ch.equals(currentChar)) {
                                int index = input.indexOf(currentChar);
                                input.set(index, newChar);
                            }
                        }
//                    int index = input.indexOf(currentChar);
//                    input.set(index, newChar);

                        //input.toString().replaceAll("", "currentChar");


                        for (String output : input) {
                            System.out.print(output);
                        }
                        System.out.println();
                        break;
                    case "Cut":
                        int startIndex = Integer.parseInt(command.split(" ")[1]);
                        int endIndex = Integer.parseInt(command.split(" ")[2]);
                        if (startIndex < 0 || endIndex > input.size() - 1 || startIndex > endIndex) {
                            System.out.println("Invalid indices!");
                        } else {
                            for (int i = startIndex; i <= endIndex; i++) {
                                input.remove(startIndex);

                            }
                            for (String output : input) {
                                System.out.print(output);
                            }
                            System.out.println();
                        }
                        break;
                    case "Make":
                        String newCase = command.split(" ")[1];
                        if (newCase.equals("Upper")) {
                            input.replaceAll(String::toUpperCase);
                            for (String output : input) {
                                System.out.print(output);
                            }
                            System.out.println();
                        } else if (newCase.equals("Lower")) {
                            input.replaceAll(String::toLowerCase);
                            for (String output : input) {
                                System.out.print(output);
                            }
                            System.out.println();
                        }
                        break;
                    case "Check":
                        String givenString = command.split(" ")[1];

                        if (input.contains(givenString)) {
                            System.out.printf("Message contains %s%n", givenString);
                        } else {
                            System.out.printf("Message doesn't contain %s%n", givenString);
                        }

                        break;
                    case "Sum":
                        int startIndexSum = Integer.parseInt(command.split(" ")[1]);
                        int endIndexSum = Integer.parseInt(command.split(" ")[2]);
                        int sum = 0;
                        if (startIndexSum > 0 && endIndexSum <= input.size() - 1 && endIndexSum > 0) {
                            for (int i = startIndexSum; i <= endIndexSum; i++) {
//                            String position = String.valueOf(input.indexOf(i));
//                            char ch2 = input.charAt(i);
//
//                            int ch1 = 'position';

                                String ch3 = input.get(i);
                                char test = ch3.charAt(0);


                                sum = sum + test;

                            }

                            System.out.println(sum);

                        } else {
                            System.out.println("Invalid indices!");
                        }
                        break;
                }

                command = scanner.nextLine();
            }
        }
    }
}
