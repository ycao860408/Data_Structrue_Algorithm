package myList.arrayList.linkedlist.impl;

import myList.arrayList.linkedlist.ILinkedList;



public class LinkedListImplement<E> implements ILinkedList<E> {

    private class ListNode<E> {
        public E data;
        public ListNode next;

        public ListNode(E data) {
            this.data = data;
            this.next = null;
        }
    }
    private int size;

    private ListNode<E> dummy;
    public LinkedListImplement() {
        this.dummy = new ListNode(0);
        this.size = 0;
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
    public void add(int index, E val) {
        if (index < 0 || index > this.size) {
            throw new  IllegalArgumentException("out of range!");
        }

        ListNode pre = dummy;

        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = pre.next;
        pre.next = newNode;
        this.size++;
    }

    @Override
    public void addFirst(E val) {
        add(0, val);
    }

    @Override
    public void addLast(E val) {
        add(this.size, val);
    }

    @Override
    public boolean add(E data) {
        add(this.size, data);
        return true;
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(this.size - 1);
    }

    @Override
    public boolean remove(E data) {
        ListNode pre = dummy;
        while (pre.next != null) {
            if (pre.next.data == data) break;
            pre = pre.next;
        }
        if (pre.next == null) return false;

        ListNode delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        this.size--;
        return true;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Out of range");
        }

        ListNode pre = dummy;

        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }

        ListNode delNode = pre.next;
        pre.next = delNode.next;
        delNode.next = null;
        this.size--;
        return (E) delNode.data;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Out of range");
        }

        ListNode cur = dummy.next;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return (E) cur.data;
    }

    @Override
    public void set(int index, E data) {
        if (index < 0 || index >= this.size) {
            throw new IllegalArgumentException("Out of range");
        }

        ListNode cur = dummy.next;

        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.data = data;
    }

    @Override
    public E getFirst() {
        return get(0);
    }

    @Override
    public E getLast() {
        return get(this.size - 1);
    }

    @Override
    public boolean contains(E data) {
        ListNode cur = dummy.next;

        while (cur != null) {
            if (cur.data.equals(data)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public void print() {
        ListNode cur = dummy.next;
        while (cur != null) {
            System.out.print(cur.data + "->");
            cur = cur.next;
        }
        System.out.println("null");
    }
}
