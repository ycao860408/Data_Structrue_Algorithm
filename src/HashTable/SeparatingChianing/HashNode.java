package HashTable.SeparatingChianing;

import java.util.HashMap;

public class HashNode <K, V> {
    public K key;
    public V value;

    public HashNode next;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
