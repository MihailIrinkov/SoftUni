package StackIterator_03;

import java.util.Iterator;
import java.util.List;

public class Stack<Integer> implements Iterable<Integer> {
    private List<Integer> data;

    public Stack (List<Integer> data) {
        this.data = data;
    }

//    public void push () {
//        this.data.add
//    }

    public void pop() {

        if (data.isEmpty()) {
            System.out.println("No elements");
        } else {

            int currentIndex = data.size() - 1;
            data.remove(currentIndex);
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
