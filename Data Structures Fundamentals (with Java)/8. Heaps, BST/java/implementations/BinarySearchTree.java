package implementations;

import interfaces.AbstractBinarySearchTree;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {
    private Node<E> root;

    public BinarySearchTree() {

    }

    public BinarySearchTree(Node<E> root) {
        this.root = root;
    }

    @Override
    public void insert(E element) {
        Node<E> newNode = new Node<>(element);
        if (this.root == null) {
            this.root = newNode;
        } else {
            Node<E> parent = null;
            Node<E> current = this.root;

            while (current != null) {
                int compare = current.value.compareTo(element);
                if (compare > 0) {
                    parent = current;
                    current = current.leftChild;
                } else if (compare < 0){
                    parent = current;
                    current = current.rightChild;
                } else {
                    return;
                }
            }

            if (parent.value.compareTo(element) > 0){
                parent.leftChild = newNode;
            } else {
                parent.rightChild = newNode;
            }
        }
    }

    @Override
    public boolean contains(E element) {
        Node<E> current = this.root;
        while (current != null){
            if (element.compareTo(current.value) < 0){
                current = current.leftChild;
            } else if (element.compareTo(current.value) > 0){
                current = current.rightChild;
            } else {
                break;
            }
        }
        return current != null;
    }

    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        Node<E> current = this.root;

        while (current != null){
            if (element.compareTo(current.value) < 0) {
                current = current.leftChild;
            } else if (element.compareTo(current.value) > 0) {
                current = current.rightChild;
            } else {
                break;
            }
        }
        return new BinarySearchTree<>(current);
    }

    @Override
    public Node<E> getRoot() {
        return this.root;
    }

    @Override
    public Node<E> getLeft() {
        return this.root.leftChild;
    }

    @Override
    public Node<E> getRight() {
        return this.root.rightChild;
    }

    @Override
    public E getValue() {
        return this.root.value;
    }
}
