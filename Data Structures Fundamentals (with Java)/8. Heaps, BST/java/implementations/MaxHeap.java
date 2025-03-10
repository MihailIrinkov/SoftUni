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
        while (hasParent(index) && less(parent(index), elements.get(index))) {
            int parentAt = getParentAt(index);
            Collections.swap(this.elements, parentAt, index);
            index = parentAt;
        }
    }

    private boolean hasParent(int index) {
        return index > 0;
    }

    private int getParentAt(int index) {
        return (index - 1) / 2;
    }

    private E parent(int index) {
        return elements.get(getParentAt(index));
    }

    private boolean less(E first, E second) {
        return first.compareTo(second) < 0;
    }

    @Override
    public E peek() {
        if (this.size() == 0) {
            throw new IllegalStateException("Heap is empty upon peek attempt");
        }
        return this.elements.get(0);
    }
}
