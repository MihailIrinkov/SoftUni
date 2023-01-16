package StrategyPattern_06;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
//        int ageCompare = Integer.compare(o1.getAge(), o2.getAge());
//
//        return ageCompare;
        return o1.getAge() - o2.getAge();
    }
}
