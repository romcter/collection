package list;

public interface SelfList<T> {

    boolean add(T item);
    T get(int index);
    boolean remove(T item);
    boolean remove(int index);
    int size();
    boolean contain(T item);
    int indexOf(T item);
    boolean clear();
}
