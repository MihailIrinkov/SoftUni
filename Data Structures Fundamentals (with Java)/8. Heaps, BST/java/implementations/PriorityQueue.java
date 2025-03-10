package implementations;

import interfaces.AbstractQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>> implements AbstractQueue<E> {
    private List<E> elements;

    public PriorityQueue() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public void add(E element) {
        this.elements.add(element);
        this.heapifyUp(this.size() - 1);
    }

    private void heapifyUp(int index) {
        while (index > 0 && less(parent(index), elements.get(index))) {
            int parentAt = getParentAt(index);
            Collections.swap(this.elements, parentAt, index);
            index = parentAt;
        }
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
        ensureNonEmpty();
        return this.elements.get(0);
    }

    private void ensureNonEmpty() {
        if (this.size() == 0) {
            throw new IllegalStateException("Heap is empty upon peek/poll attempt");
        }
    }

    @Override
    public E poll() {
        ensureNonEmpty();
        E element = this.elements.get(0);
        Collections.swap(this.elements, 0, this.elements.size() - 1);
        this.elements.remove(this.elements.size() - 1);
        this.heapifyDown(0);
        return element;
    }

    private void heapifyDown(int index) {
        while (index < this.elements.size() / 2) {
            int child = 2 * index + 1;

            if (child + 1 < this.elements.size() && less(this.elements.get(child), this.elements.get(child + 1))) {
                child = child + 1;
            }

            if (less(this.elements.get(child), this.elements.get(index))) {
                break;
            }

            Collections.swap(this.elements, index, child);
            index = child;
        }
    }
}
