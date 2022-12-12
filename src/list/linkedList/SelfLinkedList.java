package list.linkedList;

import list.SelfList;
import list.iterator.SelfCollection;
import list.iterator.SelfIterator;

import java.util.Objects;
import java.util.function.Predicate;

public class SelfLinkedList<T> implements SelfList<T>, SelfCollection {

    Node<T> head;
    int size;

    @Override
    public boolean add(T t) {
        if (Objects.isNull(head)) {
            this.head = new Node<>(t);
            size++;
            return true;
        }
        if (this.head.hasNext())
            return iterate(next -> {
                if (!next.next.hasNext()) {
                    return addNode(t, next.next);
                }
                return false;
            }
//            , () -> addNode(t, this.head)
            );
        else
            return addNode(t, this.head);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return getByIndex(index).value;
    }

    @Override
    public boolean remove(T t) {
        return iterate(node -> {
            if (node.value.equals(t)) {
                return removeNode(node);
            }
            return false;
        }
//        , () ->
                );
    }

    @Override
    public boolean remove(int index) {
        checkIndex(index);
        Node<T> removingNode = getByIndex(index);
        return removeNode(removingNode);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contain(T element) {
        return iterate(node -> node.value.equals(element));
    }

    @Override
    public int indexOf(T item) {
        int index = 0;
        for (Node<T> x = head; x != null; x = x.next) {
            if (x.value.equals(item))
                return index;
            index++;
        }
        return -1;
    }

    @Override
    public boolean clear() {
        for (Node<T> node = head; node != null; node = node.next) {
            node.value = null;
            node.previous = null;
        }
        size = 0;
        return true;
    }

    @Override
    public SelfIterator getIterator() {
        return null;
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

    private boolean addNode(T t, Node<T> next) {
        Node<T> newNode = new Node<>(t);
        newNode.previous = next;
        next.next = newNode;
        size++;
        return true;
    }

    private boolean removeNode(Node<T> node){
        node.previous.next = node.next;
        node.next.previous = node.previous;
        size--;
        return true;
    }

    private Node<T> getByIndex(int index){
        Node<T> x = head;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    }

    private void checkIndex(int index) {
        if(index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    public boolean iterate(Predicate<Node<T>> predicate/*, Supplier consumer*/) {
        Node<T> next = head;
        while (next.hasNext()) {
            if (predicate.test(next))
                return true;
            next = next.next;
        }
        return false;
    }
}
