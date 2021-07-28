package myList.arrayList;

import myList.arrayList.impl.ArrayListImpl;
import myList.arrayList.linkedlist.ILinkedList;
import myList.arrayList.linkedlist.impl.LinkedListImplement;

public class Main {
    public static void main(String[] args) {
        /*IArrayList array = new ArrayListImpl(1);
        *//*array.add(1);
        array.add(2);
        array.add(3);
        array.add(0, 0);
        array.print();
        array.remove(1);
        array.print();
        array.add(1, 4);
        array.print();
        array.removeElement(4);
        array.print();
        System.out.println(array.get(0));
        array.set(0, -1);
        array.print();*//*
        for (int i = 0; i < 11; i++) {
            array.add(0, i);
            array.print();
            System.out.println();
        }
        for (int i = 0; i < 6; i++) {
            int k = ++i;
            while (k < 5) {
                System.out.println(i);
                break;
            }
        }*/
        ILinkedList<Integer> linkedList =  new LinkedListImplement<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.print();
        linkedList.add(0, 11);
        linkedList.print();
        linkedList.remove(0);
        linkedList.print();
        Integer val = 6;
        linkedList.remove(val);
        linkedList.print();
        linkedList.remove(val = 3);
        linkedList.print();
    }

}
