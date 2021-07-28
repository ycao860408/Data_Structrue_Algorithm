package myList.arrayList.linkedlist;

public interface ILinkedList <E>{

    int size();

    boolean isEmpty();



    void add(int index, E val);

    boolean add(E data);

    void addFirst(E val);

    void addLast(E val);

    E removeFirst();

    E removeLast();

    boolean remove(E data);

    E remove(int index);

    E get(int index);

    void set(int index, E data);

    E getFirst();

    E getLast();

    boolean contains(E data);

    void print();

}
