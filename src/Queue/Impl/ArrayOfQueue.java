package Queue.Impl;

import Queue.MyQueue;

import java.util.Arrays;

public class ArrayOfQueue<E> implements MyQueue<E> {
    private E[] data;
    private int head, tail;
    private int size;

    public ArrayOfQueue() {
        this(10);
    }
    public ArrayOfQueue(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.head = this.tail = this.size = 0;
    }
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean offer(E e) {
        if (tail == data.length) {
            resize(data.length * 2);
        }
        data[tail++] = e;
        this.size++;
        return true;
    }

    @Override
    public E poll() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("The queue is empty!");
        }
        E res = data[head++];
        if (head == data.length) {
            head = 0;
        }
        this.size--;
        return res;
    }

    @Override
    public E peek() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("The queue is empty!");
        }
        return data[head];
    }

    @Override
    public void print() {
        System.out.println("Size: " + this.size);
        System.out.println("Capacity: " + this.data.length);
        for (int i = head; i < tail; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    private void resize(int newLen) {
        E[] newData = (E[]) new Object[newLen];
        for (int i = head; i < tail; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
