package GenericSwapMethodString_03;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add (T element) {
        elements.add(element);
    }

    public void swap (int firstIndex, int secondIndex) {
        T first = this.elements.get(firstIndex);
        T second = this.elements.get(secondIndex);

        this.elements.set(firstIndex, second);
        this.elements.set(secondIndex, first);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (T e : elements) {
            sb.append(e.getClass().getName() + ": " + e + "\n");
        }
        return sb.toString();
    }
}
