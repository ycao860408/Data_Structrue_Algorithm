package HashTable.OpenAddressing.impl;

import HashTable.IHashTable;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        IHashTable<Integer, Integer> myTable = new HashTableOpenAddressing<>();
        myTable.put(1, 1);
        myTable.put(11, 1);
        myTable.put(21, 1);
        myTable.put(12, 1);
        myTable.put(22, 1);
        myTable.print();
        System.out.println(myTable.get(5));
        myTable.put(33, 1);
        myTable.print();
        myTable.delete(33);
        myTable.print();
        System.out.println(myTable.get(21));
        System.out.println(myTable.get(11));
        System.out.println(myTable.get(12));
        System.out.println(myTable.get(22));
        System.out.println(myTable.get(1));
        myTable.delete(1);
        myTable.print();
    }
}
