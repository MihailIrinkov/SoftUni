package StackIterator_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Integer> data = new ArrayList<>();

        Stack<Integer> stack = new Stack<>(data);

        while (!command.equals("END")) {

            String[] input = command.split("([, ]+)");

            if (input[0].equals("Push")) {
                for (int i = 1; i < input.length; i++) {
                    data.add(Integer.parseInt(input[i]));
                }
            }

            switch (command) {
                case "Push":

                    break;
                case "Pop":
                    stack.pop();
                    break;
            }

            command = scanner.nextLine();
        }

        if (!data.isEmpty()) {
            for (int i = data.size() - 1; i >= 0; i--) {
                System.out.println(data.get(i));
            }

            for (int i = data.size() - 1; i >= 0; i--) {
                System.out.println(data.get(i));
            }
//        } else {
//            System.out.println("No elements");
//        }

        }
    }
}
