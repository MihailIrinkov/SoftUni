package Collection_02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<String> data = Arrays.stream(input.split("\\s+")).skip(1)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        ListyIterator listyIterator = new ListyIterator(data);

        while (!command.equals("END")) {

            switch (command) {
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
            }

            command = scanner.nextLine();
        }

    }
}
