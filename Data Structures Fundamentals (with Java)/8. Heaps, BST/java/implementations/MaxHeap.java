package implementations;

import interfaces.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {
    private List<E> elements;

    public MaxHeap() {
        this.elements = new ArrayList<>();
    }

    @Override
    public void add(E element) {
        this.elements.add(element);
        this.heapifyUp(this.size() - 1);
    }

    @Override
    public int size() {
        return this.elements.size();
    }


    private void heapifyUp(int index) {
        while (index > 0 && isLess(getParentAt(index), index)) {
            Collections.swap(this.elements, getParentAt(index), index);
            index = getParentAt(index);
        }
    }

    private boolean isLess(int childIndex, int parentIndex) {
        return getAt(childIndex).compareTo(getAt(parentIndex)) < 0;
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
        if (this.size() == 0) {
            throw new IllegalStateException("Illegal call to peek on empty heap!");
        }
        return getAt(0);
    }

    private E getAt(int index) {
        return this.elements.get(index);
    }
}
