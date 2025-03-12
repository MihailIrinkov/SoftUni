package implementations;

import interfaces.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {
    private List<Integer> elements;

    @Override
    public void add(E element) {

    }

    @Override
    public int size() {
        return this.elements.size();
    }


    private void heapifyUp(int index) {

    }

    private boolean hasParent(int index) {
        return false;
    }

    private int getParentAt(int index) {
        return 0;
    }

    private E parent(int index) {
        return null;
    }

    private boolean less(E first, E second) {
        return false;
    }

    @Override
    public E peek() {

        return null;
    }
}
