package HashTable.OpenAddressing.impl;

import HashTable.IHashTable;
import HashTable.OpenAddressing.HashNode;

public class HashTableOpenAddressing<K, V> implements IHashTable <K, V> {
    private HashNode[]hashNodes ;
    private int capacity;
    private int size;

    public HashTableOpenAddressing() {
        this(5);
    }

    public HashTableOpenAddressing(int capacity) {
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
        int idx = hash(key);
        // 扩容！！！
        int start = idx;
        while (hashNodes[idx] != null && !hashNodes[idx].deleted) {
            if (hashNodes[idx].key.equals(key)) {
                hashNodes[idx].value = val;
                return;
            }
            idx = (idx + 1) % capacity;
            if (idx == start) {
                resize();
                idx = hash(key);
                start = idx;
            }
        }
        hashNodes[idx] = newNode;
        size++;
    }

    private void resize() {
        capacity *= 2;
        HashNode[] oldHashNodes = hashNodes;
        hashNodes = new HashNode[capacity];
        size = 0;
        for (int i = 0; i < oldHashNodes.length; i++) {
            if (oldHashNodes[i] != null) {
                this.put((K)oldHashNodes[i].key, (V)oldHashNodes[i].value);
            }
        }
    }

    @Override
    public V get(K key) {
        int idx = hash(key);
        int start = idx;
        while (hashNodes[idx] != null && !hashNodes[idx].deleted) {
            if (hashNodes[idx].key.equals(key)) {
                return (V)hashNodes[idx].value;
            }
            idx = (idx + 1) % capacity;
            if (idx == start) {
                break;
            }
        }
        return null;
    }

    @Override
    public V delete(K key) {
        int idx = hash(key);
        int start = idx;
        while (hashNodes[idx] != null && !hashNodes[idx].deleted) {
            if (hashNodes[idx].key.equals(key)) {
                hashNodes[idx].deleted = true;
                size--;
                return (V) hashNodes[idx].value;
            }
            idx = (idx + 1) % capacity;
            if (idx == start) {
                break;
            }
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void print() {
        for (HashNode<K, V> node : hashNodes) {
            if (node != null &&!node.deleted) {
                System.out.print("key: " + node.key + ",value: " + node.value + " -> ");
            }
        }
        System.out.println("null");
        System.out.println("Size: " + this.size);
        System.out.println("Capacity: " + this.capacity);
    }
}
