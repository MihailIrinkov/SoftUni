package solutions;

import interfaces.Decrease;
import interfaces.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinHeap<E extends Comparable<E> & Decrease<E>> implements Heap<E> {
    private List<E> data;

    public MinHeap() {
        this.data = new ArrayList<>();
    }

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public void add(E element) {
        this.data.add(element);
        this.heapifyUp();
    }

    private void heapifyUp() {
        int index = this.data.size() - 1;
        int parentIndex = this.getParentIndexFor(index);

        while (index > 0 && isLess(index, parentIndex)) {
            Collections.swap(this.data, index, parentIndex);
            index = parentIndex;
            parentIndex = this.getParentIndexFor(index);
        }
    }

    private int getParentIndexFor(int index) {
        return (index - 1) / 2;
    }

    private boolean isLess(int firstIndex, int secondIndex) {
        return this.data.get(firstIndex).compareTo(this.data.get(secondIndex)) < 0;
    }

    @Override
    public E peek() {
        ensureNonEmpty();
        return this.data.get(0);
    }

    private void ensureNonEmpty() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException();
        }
    }

    @Override
    public E poll() {
        ensureNonEmpty();
        Collections.swap(this.data, 0, this.data.size() -1);
        E toReturne = this.data.remove(this.data.size() -1);

        this.heapifyDown();

        return toReturne;
    }

    private void heapifyDown() {
        int index = 0;
        int leftChildIndex = this.getLeftChildIndex(index);

        while (leftChildIndex < this.data.size()) {
            int swapIndex = leftChildIndex;

            int rightChildIndex = this.getRightChildIndex(index);

            if (rightChildIndex < this.data.size()) {
                swapIndex = this.data.get(leftChildIndex).compareTo(this.data.get(rightChildIndex)) < 0 ? leftChildIndex : rightChildIndex;
            }

            if (isLess(index, swapIndex)) {
                break;
            }

            Collections.swap(this.data, index, swapIndex);
            index = swapIndex;
            leftChildIndex = getLeftChildIndex(index);
        }
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    @Override
    public void decrease(E element) {
        this.data.remove(element);
        element.decrease();
        this.add(element);
//        int elementIndex = this.data.indexOf(element);
//
//        E heapElement = this.data.get(elementIndex);
//        heapElement.decrease();
//
//        this.heapifyUp();
    }
}
