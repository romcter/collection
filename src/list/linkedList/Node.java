package list.linkedList;

import list.iterator.SelfIterator;

import java.util.Objects;

public class Node<T> implements SelfIterator {
    Node<T> next;
    T value;
    Node<T> previous;

    public Node(Node<T> next, Node<T> previous, T value) {
        this.next = next;
        this.previous = previous;
        this.value = value;
    }

    public Node(T value) {
        this.value = value;
    }

    @Override
    public boolean hasNext() {
        return this.next != null;
    }

    @Override
    public Object next() {
        return this.next;
    }

    @Override
    public String toString() {
        return "Node{" +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(next, node.next) && Objects.equals(value, node.value) && Objects.equals(previous, node.previous);
    }

    @Override
    public int hashCode() {
        return Objects.hash(next, value, previous);
    }
}
