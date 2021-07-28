package stack;

public interface LinkedListStack<E> {

    int size();

    boolean isEmpty();

    void push(E e);

    E pop() ;

    E peek() ;

    void print();

}
