package CustomList_07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public void add (T element) {
        this.elements.add(element);
    }

    public T remove (int index) {
        return this.elements.remove(index);
    }

    public boolean contains (T element) {
       return this.elements.contains(element);
    }

    public void swap (int firstIndex, int secondIndex) {

        T firstElement = this.elements.get(firstIndex);
        T secondElement = this.elements.get(secondIndex);

        this.elements.set(firstIndex, secondElement);
        this.elements.set(secondIndex, firstElement);
    }

    public int countGreaterThan (T element) {

        int count = 0;

        for (T e : this.elements) {
            if (e.compareTo(element) > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
       return Collections.max(this.elements);
    }

    public T getMin() {
        return Collections.min(this.elements);
        //return this.elements.stream().min((e1, e2) -> e1.compareTo(e2)).get();
    }

    public void print() {
        for (T e : this.elements) {
            System.out.println(e);
        }
    }
}
