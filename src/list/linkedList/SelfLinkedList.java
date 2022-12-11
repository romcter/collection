package list.linkedList;

import list.SelfList;
import list.iterator.SelfCollection;
import list.iterator.SelfIterator;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class SelfLinkedList<T> implements SelfList<T>, SelfCollection {

    Node<T> head;
    int size;

    public boolean iterate(Predicate<Node<T>> consumer) {
        Node<T> next = head;
        while (next.hasNext()) {
            if (consumer.test(next))
                break;
            next = next.next;
        } return true;
    }

    @Override
    public boolean add(T t) {
        if (head == null) {
            this.head = new Node<>(t);
            size++;
            return true;
        }
        if (this.head.hasNext()) {
            return iterate(next -> {
                if (!next.next.hasNext()) {
                    return addNewNode(t, next.next);
                }
                return false;
            });
        } else
            return addNewNode(t, this.head);
//        Node<T> next = head;
//        while (next.hasNext()) {
//            if (!next.next.hasNext()) {
//                return addNewNode(t, next.next);
//            }
//            next = next.next;
//        }
    }

    private boolean addNewNode(T t, Node<T> next){
        Node<T> newNode = new Node<>(t);
        newNode.previous = next;
        next.next = newNode;
        size++;
        return true;
    }

    private BiFunction<T, Node<T>, Boolean> supplier(){
        return (x, y) -> {
            Node<T> newNode = new Node<>(x);
            newNode.previous = y;
            y.next = newNode;
            size++;
            return true;
        };
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public boolean remove(T t) {
        Node<T> next = head;
        while (next.hasNext()) {
            if (next.value.equals(t)){
                next.previous.next = next.next;
                next.next.previous = next.previous;
                size--;
                return true;
            }
            next = next.next;
        }
        return false;
    }

    @Override
    public boolean remove(int index) {

        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contain(Object element) {

        return false;
    }

    @Override
    public SelfIterator getIterator() {
        return null;
    }

    private int i() {
        int size = 0;
        while (head.hasNext()) {
            size++;
        }
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SelfLinkedList<?> that = (SelfLinkedList<?>) o;
        return size == that.size && Objects.equals(head, that.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, size);
    }

    @Override
    public String toString() {
        return "SelfLinkedList{" +
                "head=" + head +
                ", size=" + size +
                '}';
    }
}
