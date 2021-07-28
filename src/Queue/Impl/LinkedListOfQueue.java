package Queue.Impl;

import Queue.MyQueue;

public class LinkedListOfQueue<E> implements MyQueue<E> {
    private ListNode head, tail;
    private int size;

    public LinkedListOfQueue() {
        this.size = 0;
        this.head = this.tail = null;
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
        if (tail == null) {
            this.tail = new ListNode(e);
            this.head = this.tail;

        } else {
            this.tail.next = new ListNode(e);
            this.tail = this.tail.next;
        }
        this.size++;
        return true;
    }

    @Override
    public E poll() {
        if (this.isEmpty())
            throw new IllegalArgumentException("The queue is empty!");

        ListNode res = this.head;
        this.head = this.head.next;
        if (this.head == null) {
            this.tail = null;
        }
        res.next = null;
        this.size--;
        return (E)res.data;
    }

    @Override
    public E peek() {
        if (this.isEmpty())
            throw new IllegalArgumentException("The queue is empty!");
        return (E) this.head.data;
    }

    @Override
    public void print() {
        ListNode cur = this.head;

        while (cur != null) {
            System.out.print(cur.data + "->");
            cur = cur.next;
        }
        System.out.println("null");
    }

    private class ListNode<E> {
        public E data;
        public ListNode next;
        public ListNode(E data) {
            this.data = data;
            this.next = null;
        }
    }
}
