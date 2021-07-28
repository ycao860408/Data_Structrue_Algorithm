package HashTable.SeparatingChianing.impl;

import HashTable.IHashTable;
import HashTable.SeparatingChianing.HashNode;

public class HashTableSeparateChaining<K, V> implements IHashTable<K, V> {
    private HashNode[]hashNodes ;
    private int capacity;
    private int size;

    public HashTableSeparateChaining() {
        this(10);
    }

    public HashTableSeparateChaining(int capacity) {
        this.capacity = capacity;
        this.hashNodes = new HashNode[this.capacity];
        this.size = 0;
    }

    private int hash(K key) {
        return  key.hashCode() % this.capacity;
    }
    @Override
    public void put(K key, V val) {
        HashNode<K, V> newNode = new HashNode<>(key, val);
        int idx = this.hash(key);
        HashNode curNode = hashNodes[idx];

        if (curNode == null) {
            hashNodes[idx] = newNode;
        } else {
            while (!curNode.key.equals(key) && curNode.next != null) {
                curNode = curNode.next;
            }
            if (curNode.key.equals(key)) {
                curNode.value = val;
                return;
            }
            curNode.next = newNode;
        }
        this.size++;
    }

    @Override
    public V get(K key) {
        int idx = this.hash(key);
        HashNode curNode = hashNodes[idx];

        while (curNode != null) {
            if (curNode.key.equals(key)) {
                return (V) curNode.value;
            }
            curNode = curNode.next;
        }
        return null;
    }

    @Override
    public V delete(K key) {
        int idx = this.hash(key);
        HashNode curNode = hashNodes[idx];
        HashNode pre = null;

        while (curNode != null) {
            if (curNode.key.equals(key)) {
                break;
            }
            pre = curNode;
            curNode = curNode.next;
        }

        if (curNode != null) {
            if (pre == null) {
                hashNodes[idx] = curNode.next;
            } else {
                pre.next = curNode.next;
                curNode.next = null;
            }
            this.size--;
            return (V) curNode.value;
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void print() {
        for (HashNode<K, V> hashNode : hashNodes) {
            if (hashNode != null) {
                while (hashNode != null) {
                    System.out.print("Key: " + hashNode.key + ",value: " + hashNode.value + " -> ");
                    hashNode = hashNode.next;
                }
                System.out.println("null");
            }
        }
        System.out.println("size: " + this.size);
    }
}
