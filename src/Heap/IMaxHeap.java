package Heap;

public interface IMaxHeap<E> {

    int size();

    boolean offer(E item);

    E poll();

    E peek();

    boolean isEmpty();

    void print();

}
