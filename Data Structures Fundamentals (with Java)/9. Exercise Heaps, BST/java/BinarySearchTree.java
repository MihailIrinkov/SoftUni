import solutions.BinaryTree;

import java.util.function.Consumer;

import java.util.List;

public class BinarySearchTree<E extends Comparable<E>> {
    private Node<E> root;

    public BinarySearchTree(E element) {
        this.root = new Node<>(element);
    }

    public BinarySearchTree(Node<E> otherRoot) {
        this.root = new Node<>(otherRoot);
    }

    public static class Node<E> {
        private E value;
        private Node<E> leftChild;
        private Node<E> rightChild;

        public Node(E value) {
            this.value = value;
        }

        public Node(Node<E> other) {
            this.value = other.value;

            if (other.getLeft() != null) {
                this.leftChild = new Node<>(other.getLeft());
            }

            if (other.getRight() != null) {
                this.rightChild = new Node<>(other.getRight());
            }
        }


        public Node<E> getLeft() {
            return this.leftChild;
        }

        public Node<E> getRight() {
            return this.rightChild;
        }

        public E getValue() {
            return this.value;
        }
    }

    public void eachInOrder(Consumer<E> consumer) {
        nodeInOrder(this.root, consumer);
    }

    private void nodeInOrder(Node<E> node, Consumer<E> consumer) {
        if (node == null) {
            return;
        }

        nodeInOrder(node.getLeft(), consumer);
        consumer.accept(node.getValue());
        nodeInOrder(node.getRight(), consumer);
    }

    public Node<E> getRoot() {
        return this.root;
    }

    public void insert(E element) {
        insertInto(this.root, element);
    }

    private void insertInto(Node<E> node, E element) {
        if (isGreater(element, node)) {
            if (node.getRight() == null) {
                node.rightChild = new Node<>(element);
            } else {
                insertInto(node.getRight(), element);
            }
        } else if (isLess(element, node)) {
            if (node.getLeft() == null) {
                node.leftChild = new Node<>(element);
            } else {
                insertInto(node.getLeft(), element);
            }
        }
    }

    public boolean contains(E element) {
//        return containsNode(this.root, element);

        Node<E> current = this.root;

        while (current != null) {
            if (isEqual(element, current)) {
                break;
            } else if (isGreater(element, current)) {
                current = current.getRight();
            } else {
                current = current.getLeft();
            }
        }

        return current != null;
    }

    private Node<E> containsNode(Node<E> node, E element) {
        if (node == null) {
            return null;
        }

        if (isEqual(element, node)) {
            return node;
        } else if (isGreater(element, node)) {
            return containsNode(node.getRight(), element);
        }

        return containsNode(node.getLeft(), element);
    }

    public BinarySearchTree<E> search(E element) {
        Node<E> found = containsNode(this.root, element);

        return found == null ? null : new BinarySearchTree<>(found);
    }

    public List<E> range(E first, E second) {
        return null;
    }

    public void deleteMin() {

    }

    public void deleteMax() {

    }

    public int count() {
        return 0;
    }

    public int rank(E element) {
        return 0;
    }

    public E ceil(E element) {
        return null;
    }

    public E floor(E element) {
        return null;
    }

    private boolean isEqual(E element, Node<E> node) {
        return element.compareTo(node.getValue()) == 0;
    }

    private boolean isLess(E element, Node<E> node) {
        return element.compareTo(node.getValue()) < 0;
    }

    private boolean isGreater(E element, Node<E> node) {
        return element.compareTo(node.getValue()) > 0;
    }
}
