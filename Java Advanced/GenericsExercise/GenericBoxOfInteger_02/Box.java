package GenericBoxOfInteger_02;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> elements;

    public Box() {
        this.elements = new ArrayList<>();
    }

    public void add(T element) {
        elements.add(element);
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
