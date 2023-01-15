package ComparingObjects_05;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        List<Person> persons = new ArrayList<>();

        while (!command.equals("END")) {
            String name = command.split("\\s+")[0];
            String town = command.split("\\s+")[2];
            int age = Integer.parseInt(command.split("\\s+")[1]);

            Person person = new Person(name, age, town);

            persons.add(person);

            command = scanner.nextLine();
        }

        int n = Integer.parseInt(scanner.nextLine());

        Person searchedPerson = persons.get(n -1);

        int counter = 0;

        for (Person p : persons) {
            if (searchedPerson.compareTo(p) == 0) {
                counter++;
            }
        }

        if (counter == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d", counter, (persons.size() - counter), persons.size());
        }
    }
}
