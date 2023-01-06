package CustomListSorter_08;

import java.util.ArrayList;
import java.util.List;

public class CustomList<T extends Comparable<T>> {
    private List<T> elements;

    public CustomList() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        this.elements.add(element);
    }

    public void remove(int index) {
        this.elements.remove(index);
    }

    public boolean contains(T element) {
        return this.elements.contains(element);
    }

    public void swap(int firstIndex, int secondIndex) {
        T first = this.elements.get(firstIndex);
        T second = this.elements.get(secondIndex);

        this.elements.set(firstIndex, second);
        this.elements.set(secondIndex, first);
    }

    public int greater(T element) {
        int count =0;

        for (T e : this.elements) {
            if (e.compareTo(element) > 0) {
                count++;
            }
        }

        return count;
    }

    public T max() {
        return this.elements.stream().max((e1, e2) -> e1.compareTo(e2)).get();
    }

    public T min() {
        return this.elements.stream().min((e1, e2) -> e1.compareTo(e2)).get();
    }

    public void print() {
        for (T e : this.elements) {
            System.out.println(e);
        }
    }

    public void sort() {
        this.elements.sort((e1, e2) -> e1.compareTo(e2));
    }

}
