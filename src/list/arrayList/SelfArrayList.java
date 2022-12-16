package list.arrayList;

import list.SelfList;

import java.util.Objects;

public class SelfArrayList<T> implements SelfList<T> {
    transient Object[] elementData;
    private final int DEFAULT_CAPACITY = 10;
    private double loadFactory = 0.75;
    int size;


    public SelfArrayList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    public SelfArrayList(int baseCapacity) {
        this.elementData = new Object[baseCapacity];
    }

    public SelfArrayList(double loadFactory) {
        this.loadFactory = loadFactory;
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(T element) {
        if ((double)size / (double)elementData.length >= loadFactory) {
            Object[] newArr = new Object[size * 2];
            System.arraycopy(elementData, 0, newArr, 0, size + 1);
            elementData = newArr;
        }
        elementData[size] = element;
        size++;
        return true;
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elementData[index];
    }

    @Override
    public boolean remove(Object element) {
        for (int index = 0; index < size; index++) {
            if (elementData[index].equals(element)) {
                return deleteAndPushLeft(index);
            }
        }
        return false;
    }

    private boolean deleteAndPushLeft(int index){
        elementData[index] = null;
        for (int i = index + 1; i < size; i++) {
            elementData[index++] = elementData[i];
        }
        size--;
        return true;
    }

    @Override
    public boolean remove(int index) {
        checkIndex(index);
        return deleteAndPushLeft(index);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(T item) {
        for (int index = 0; index < size; index++) {
            if (elementData[index].equals(item)) {
                return index;
            }
        }
        return -1;
    }

    @Override
    public boolean clear() {
        for (int index = 0; index < size; index++)
            elementData[index] = null;
        size = 0;
        return true;
    }

    @Override
    public boolean contain(T item) {
        return indexOf(item) >= 0;
    }

    private void checkIndex(int index) {
        Objects.checkIndex(index, size);
    }
}
