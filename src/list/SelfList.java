package list;

public interface SelfList<T> {

    boolean add(T element);
    T get(int index);
    boolean remove(T element);
    boolean remove(int index);
    int size();
    boolean contain(T element);
}
