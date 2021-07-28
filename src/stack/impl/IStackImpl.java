package stack.impl;

import myList.arrayList.IArrayList;
import stack.IArrayStack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class IStackImpl<E> implements IArrayStack<E> {

    private E[] innerArray;
    private int top;

    public IStackImpl() {
        this(10);
    }
    public IStackImpl(int capacity) {
        this.innerArray = (E[]) new Object[capacity];
        this.top = 0;
    }

    @Override
    public int capacity() {
        return this.innerArray.length;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void push(E e) {
        if (this.top == innerArray.length) {
            resize(this.innerArray.length * 2);
        }
        this.innerArray[this.top++] = e;
    }

    @Override
    public E pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        E result = this.innerArray[--this.top];
        this.innerArray[top] = null;
        if (this.top < this.innerArray.length / 2) {
            resize(this.innerArray.length / 2);
        }
        return result;
    }

    @Override
    public E peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        }
        E result = this.innerArray[this.top - 1];
        return result;
    }

    private void resize(int size) {
        E[] newArray = (E[]) new Object[size];

        for (int i = 0; i < this.top; i++) {
            newArray[i] = this.innerArray[i];
        }
        this.innerArray = newArray;
    }


    public void print() {
       for (int i = 0; i < this.top; i++) {
           System.out.print(this.innerArray[i] + " ");
       }
       System.out.println();
    }
}
