package OpinionPoll_01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String nameInput = input[0];
            int ageInput = Integer.parseInt(input[1]);

            Person person = new Person(nameInput, ageInput);

            people.add(person);
        }
        people.stream().filter(e -> e.getAge() > 30)
                .sorted((a, b) -> a.getName().compareTo(b.getName()))
                .forEach(e -> System.out.println(e));
    }
}
