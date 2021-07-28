package Queue.Impl;

import Queue.MyQueue;

public class CircularArrayQueue<E> implements MyQueue<E> {
    private E[] data;
    private int head, tail;

    public CircularArrayQueue() {
        this(10);
    }

    public CircularArrayQueue(int capacity) {
        data = (E[]) new Object[capacity];
        this.head = this.tail = 0;
    }
    @Override
    public int size() {
        return (tail - head + data.length) % data.length;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public boolean offer(E e) {
        data[tail] = e;
        if ((tail = (tail + 1) % data.length) == head) {
            resize(2 * data.length);
        }
        return true;
    }

    @Override
    public E poll() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("The que is empty");
        }

        E res = data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        return res;
    }

    @Override
    public E peek() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("The que is empty");
        }
        return data[head];
    }

    @Override
    public void print() {
        System.out.println("Size: " + this.size());
        System.out.println("Capacity: " + data.length);
        for (int i = head; i % data.length < tail; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    private void resize(int capacity) {
        E[] newData = (E[]) new Object[capacity];
        ;
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[(i + head) % data.length];
        }
        head = 0;
        tail = data.length;
        data = newData;
    }

}
