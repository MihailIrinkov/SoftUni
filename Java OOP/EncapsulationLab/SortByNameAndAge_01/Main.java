package SortByNameAndAge_01;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);

            Person person = new Person(firstName, lastName, age);

            persons.add(person);
        }

        Collections.sort(persons, (firsPerson, secondPerson)
    -> {
            int result = firsPerson.getFirstName().compareTo(secondPerson.getFirstName());

            if (result != 0) {
                return result;
            } else {
                result = Integer.compare(firsPerson.getAge(), secondPerson.getAge());
            }
            return result;
                }

    );

        for (Person p : persons) {
            System.out.println(p.toString());
        }
    }
}
