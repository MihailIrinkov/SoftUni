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

    private boolean isLess(int first, int second) {
        return getAt(first).compareTo(getAt(second)) < 0;
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
        ensureNonEmpty();
        return getAt(0);
    }

    private void ensureNonEmpty() {
        if (this.size() == 0) {
            throw new IllegalStateException("Illegal call to peek on empty heap!");
        }
    }

    @Override
    public E poll() {
        ensureNonEmpty();
        E returneValaue = getAt(0);

        Collections.swap(this.elements, 0, this.size() - 1);
        this.elements.remove(this.size() - 1);
        this.heepifyDown(0);
        return returneValaue;
    }

    private E getLeftChild(int index) {
        return this.elements.get(this.getLeftChildIndex(index));
    }

    private E getRightChild(int index) {
        return this.elements.get(this.getRightChildIndex(index));
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private void heepifyDown(int index) {
        while (getLeftChildIndex(index) < this.size() && isLess(index, getLeftChildIndex(index))) {
            int child = getLeftChildIndex(index);
            int rightChildIndex = getRightChildIndex(index);
            if (rightChildIndex < this.size() && isLess(child, rightChildIndex)) {
                child = rightChildIndex;
            }

            Collections.swap(this.elements, child, index);
            index = child;
        }
    }

    private E getAt(int index) {
        return this.elements.get(index);
    }
}
