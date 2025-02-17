package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {
    private static final int INITIAL_SIZE = 4;
    private Object[] elements;
    private int size;
    private int capacity;

    public ArrayList() {
        this.elements = new Object[INITIAL_SIZE];
        this.size = 0;
        this.capacity = INITIAL_SIZE;
    }

    @Override
    public boolean add(E element) {
        if (this.size == this.capacity) {
            resize();
        }

        this.elements[this.size++] = element;
        return true;
    }

    private void resize() {
        this.capacity *= 2;
        Object[] resizedArr = new Object[this.capacity];

        for (int i = 0; i < this.elements.length; i++) {
            resizedArr[i] = this.elements[i];
        }

        this.elements = resizedArr;
    }

    @Override
    public boolean add(int index, E element) {

        if (!validIndex(index)) {
            return false;
        }

        shiftRight(index);

        this.elements[index] = element;

        return true;
    }

    private void shiftRight(int index) {
        for (int i = this.size - 1; i > index ; i--) {
            this.elements[i + 1] = this.elements[i];
        }
    }

    private boolean validIndex(int index) {
        return index >= 0 && index < this.size;
    }

    @Override
    public E get(int index) {
        if (!validIndex(index)) {
            throw new IndexOutOfBoundsException(
                    "Enter valid index"
            );
        }

        return (E) this.elements[index];
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }

    @Override
    public boolean contains(E element) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }
}
