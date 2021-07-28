package Heap.impl;

import Heap.IMaxHeap;

import java.util.LinkedList;
import java.util.Queue;

public class MaxHeapImpl<E extends Comparable<E>> implements IMaxHeap<E> {

    private int capacity;

    private int size;

    private E[] data;

    public MaxHeapImpl(E[] data) {
        this.data = data;
        this.capacity = data.length;
        this.size = data.length;
        heapify(this.data);
    }

    public MaxHeapImpl() {
        this.capacity = 16;
        this.size = 0;
        this.data = (E[]) new Comparable[this.capacity];
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean offer(E item) {
        if (size == capacity) {
            expandCapacity();
        }
        data[size] = item;
        size++;
        siftUp();
        return true;
    }

    @Override
    public E poll() {
        if (this.size == 0) throw new IllegalArgumentException("The heap is empty!");
        E item = data[0];
        data[0] = data[this.size - 1];
        data[this.size - 1] = null;
        size--;
        siftDown(0);
        return item;
    }

    @Override
    public E peek() {
        if (this.size == 0) throw new IllegalArgumentException("The heap is empty!");
        return (E) this.data[0];
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public void print() {
        Queue<Integer> que = new LinkedList<>();
        que.offer(0);
        while (!que.isEmpty()) {
            int len = que.size();
            for (int i = 0; i < len; i++) {
                int cur = que.poll();
                System.out.print((E)data[cur] + " ");
                int left, right;
                if ((left = getLeftChild(cur)) < size) {
                    que.offer(left);
                }
                if ((right = getRightChild(cur)) < size) {
                    que.offer(right);
                }
            }
            System.out.println();
        }
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private int getLeftChild(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChild(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private E leftChild(int idex) {
        return (E) data[getLeftChild(idex)];
    }

    private E rightChild(int idex) {
        return (E) data[getLeftChild(idex)];
    }

    private E parent(int idex) {
        return (E) data[getParentIndex(idex)];
    }

    private void swap(int i, int j) {
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    private void siftUp() {
        int idx = this.size - 1;
        while (idx > 0 && parent(idx).compareTo(data[idx]) < 0) {
            swap(idx, getParentIndex(idx));
            idx = getParentIndex(idx);
        }
    }

    private void siftDown(int startingPoint) {
        int idx = startingPoint;
        while (true) {
            int leftIdx = getLeftChild(idx);
            int rightIdx = getRightChild(idx);
            int maxIdx = idx;
            if (leftIdx < size && data[leftIdx].compareTo(data[maxIdx]) > 0) {
                maxIdx = leftIdx;
            }
            if (rightIdx < size && data[rightIdx].compareTo(data[maxIdx]) > 0) {
                maxIdx = rightIdx;
            }

            if (maxIdx == idx) break;

            swap(maxIdx, idx);
            idx = maxIdx;
        }
    }

    private void expandCapacity() {

        E[] temp = (E[]) new Comparable[this.capacity * 2];
        for (int i = 0; i < this.capacity; i++) {
            temp[i] = data[i];
        }
        this.capacity *= 2;
        this.data = temp;
    }

    private void heapify(E[] data) {
        int lastNodeWithChild = getParentIndex(this.size - 1);

        for (int idx = lastNodeWithChild; idx >= 0; idx--) {
            siftDown(idx);
        }
    }
}
