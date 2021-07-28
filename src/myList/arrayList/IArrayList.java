package myList.arrayList;

public interface IArrayList<E> {
    int capacity = 0;
    int size = 0;

    int size();
    int capacity();
    boolean isEmpty();
    void add(E e);
    void add(int idx, E e);
    boolean contains(E e);
    E get(int idx);
    void set(int idx, E e);
    E remove(int idx);
    void remove(E e);
    void print();
    void resize(int capacity);
}
