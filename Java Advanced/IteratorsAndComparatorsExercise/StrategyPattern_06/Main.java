package StrategyPattern_06;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> nameCompare = new TreeSet<>(new PersonNameComparator());
        TreeSet<Person> ageCompare = new TreeSet<>(new PersonAgeComparator());

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String name = input.split("\\s+")[0];
            int age = Integer.parseInt(input.split("\\s+")[1]);
            Person p = new Person(name, age);

            nameCompare.add(p);
            ageCompare.add(p);
        }
        for (Person p : nameCompare) {
            System.out.println(p);
        }

        for (Person p : ageCompare) {
            System.out.println(p);
        }
    }
}
