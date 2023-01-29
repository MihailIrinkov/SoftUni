package SalaryIncrease_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        List<SalaryIncrease_02.Person> persons = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            double salary = Double.parseDouble(input[3]);

            SalaryIncrease_02.Person person = new SalaryIncrease_02.Person(firstName, lastName, age, salary);

            persons.add(person);
        }

        double bonus = Double.parseDouble(scanner.nextLine());

        for (Person p : persons) {

            p.increaseSalary(bonus);
            System.out.println(p.toString());
        }
    }
}
