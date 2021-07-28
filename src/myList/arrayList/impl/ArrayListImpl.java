package myList.arrayList.impl;

import myList.arrayList.IArrayList;

public class ArrayListImpl<E> implements IArrayList<E> {
    private E[] data;
    private int size;
    public ArrayListImpl() {
        this(10);
    }
    public ArrayListImpl(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    @Override
    public int capacity() {
        return data.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(E e) {
       add(size, e);
    }

    @Override
    public void add(int idx, E e) {
        if (size == data.length) {
            //throw new IllegalArgumentException("The array is full");
            resize(data.length * 2);
        }
        if (idx < 0 || idx > size) {
           throw new IllegalArgumentException("index error");
        }

        for (int i = size; i > idx; i--) {
            data[i] = data[i - 1];
        }
        size++;
        data[idx] = e;
    }

    @Override
    public boolean contains(E e) {
        for (E item : data) {
            if (item.equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E get(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException("Out of range!");
        }
        return data[idx];
    }

    @Override
    public void set(int idx, E e) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException("Out of range!");
        }
        data[idx] = e;
    }

    @Override
    public E remove(int idx) {
        if (idx < 0 || idx >= size) {
            throw new IllegalArgumentException("range error");
        }
        E reVal = data[idx];
        for (int i = idx; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;

        if (data.length / 4 == size && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return reVal;
    }

    @Override
    public void remove(E e) {
        int idx = -1;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            throw new IllegalArgumentException("Do not have this element");
        }
        remove(idx);
    }

    @Override
    public void print() {
        System.out.println("size: " +  size);
        System.out.println("capacity: " + data.length);
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.print("\n");
    }

    @Override
    public void resize(int capacity) {
        E [] temp = (E[])new Object[capacity];
        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }
        data = temp;
    }
}
