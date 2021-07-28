package HashTable.SeparatingChianing.impl;

import HashTable.IHashTable;

public class Main {
    public static void main(String[] args) {
        HashTableSeparateChaining<Integer, Integer> hashTable = new HashTableSeparateChaining<>(5);
        hashTable.put(1, 1);
        hashTable.put(11, 1);
        hashTable.put(21, 1);
        hashTable.put(12, 1);
        hashTable.put(22, 1);
        hashTable.print();
        hashTable.put(11, 5);
        hashTable.print();
        hashTable.delete(21);
        hashTable.print();
    }
}
