package BirthdayCelebrations_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Birthable> list = new ArrayList<>();

        String input = scanner.nextLine();

        while (!input.equals("End")) {

            String[] data = input.split("\\s+");

            switch (data[0]) {

                case "Citizen":
                    list.add(new Citizen(data[1],
                            Integer.parseInt(data[2]), data[3], data[4]));

                    break;
                case "Pet":
                    list.add(new Pet(data[1], data[2]));
                    break;

            }

            input = scanner.nextLine();
        }

        String year = scanner.nextLine();

        boolean isFound = false;

        for (Birthable birthable : list) {
            if (birthable.getBirthDate().endsWith(year)) {
                isFound = true;
                System.out.println(birthable.getBirthDate());
            }

        }

        if (!isFound) {
            System.out.println("<no output>");
        }

//        if(list.isEmpty()) {
//            System.out.println("<no output>");
//        } else {
//            list.stream().map(Birthable::getBirthDate)
//                    .filter(birthDate -> birthDate.endsWith(year)).forEach(System.out::println);
//        }
    }
}
