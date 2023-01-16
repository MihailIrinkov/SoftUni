package StrategyPattern_06;

import java.util.Comparator;

public class PersonNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int comparedNames = o1.getName().length() - o2.getName().length();

        if (comparedNames == 0) {
            char n1 = o1.getName().toLowerCase().charAt(0);
            char n2 = o2.getName().toLowerCase().charAt(0);

            comparedNames = n1 - n2;

//            if (n1 > n2) {
//                return -1;
//            } else {
//                return 1;
//            }
//        } else if (comparedNames > 0) {
//            return 1;
//        }
        }
        return comparedNames;
    }
}
