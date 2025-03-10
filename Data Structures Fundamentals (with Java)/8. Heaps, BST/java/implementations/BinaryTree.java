package implementations;

import interfaces.AbstractBinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E> {
    private E key;
    private BinaryTree<E> leftChild;
    private BinaryTree<E> rightChild;

    public BinaryTree(E key, BinaryTree<E> leftChild, BinaryTree<E> rightChild) {
        this.setKey(key);
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }


    @Override
    public E getKey() {
        return key;
    }

    @Override
    public AbstractBinaryTree<E> getLeft() {
        return this.leftChild;
    }

    @Override
    public AbstractBinaryTree<E> getRight() {
        return this.rightChild;
    }

    @Override
    public void setKey(E key) {
        this.key = key;
    }

    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder result = new StringBuilder();
        String padding = createPadding(indent) + this.getKey();
        result.append(padding);

        if (this.getLeft() != null) {
            String preOrder = this.getLeft().asIndentedPreOrder(indent + 2);
            result.append(System.lineSeparator()).append(preOrder);
        }

        if (this.getRight() != null) {
            String preOrder = this.getRight().asIndentedPreOrder(indent + 2);
            result.append(System.lineSeparator()).append(preOrder);
        }

        return result.toString();
    }

    private String createPadding(int indent) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < indent; i++) {
            builder.append(" ");
        }
        return builder.toString();
    }

    @Override
    public List<AbstractBinaryTree<E>> preOrder() {

        return null;
    }

    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        return null;
    }

    @Override
    public List<AbstractBinaryTree<E>> postOrder() {

        return null;
    }

    @Override
    public void forEachInOrder(Consumer<E> consumer) {

    }
}
