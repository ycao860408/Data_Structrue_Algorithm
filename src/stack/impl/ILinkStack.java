package stack.impl;

import stack.IArrayStack;
import stack.LinkedListStack;

import java.util.LinkedList;

public class ILinkStack<E> implements LinkedListStack<E> {

    private LinkedList<E> linkedList;

    public ILinkStack() {
        this.linkedList = new LinkedList<>();
    }

    @Override
    public int size() {
        return this.linkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void push(E e) {
        this.linkedList.addFirst(e);
    }

    @Override
    public E pop() {

        return (E) this.linkedList.removeFirst();
    }

    @Override
    public E peek()  {

        return this.linkedList.getFirst();
    }

    @Override
    public void print() {
        System.out.println("Size : " + this.linkedList.size());
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.print(linkedList.get(i) + " ");
        }
        System.out.println();
    }
}
