package implementations;

import interfaces.AbstractQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>> implements AbstractQueue<E> {

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void add(E element) {

    }

    private void heapifyUp(int index) {

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

    private void ensureNonEmpty() {

    }

    @Override
    public E poll() {

        return null;
    }

    private void heapifyDown(int index) {

    }
}
