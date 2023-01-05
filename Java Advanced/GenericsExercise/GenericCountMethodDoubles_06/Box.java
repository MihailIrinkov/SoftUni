package GenericCountMethodDoubles_06;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Comparable<T>>{
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add (T element) {
        this.elements.add(element);
    }

    public int compare (T elementToCompare) {
        int count = 0;

        for (T e : this.elements) {
            if (e.compareTo(elementToCompare) > 0) {
                count++;
            }
        }
        return count;
    }
}
