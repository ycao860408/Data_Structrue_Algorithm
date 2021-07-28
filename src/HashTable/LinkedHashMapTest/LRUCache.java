package HashTable.LinkedHashMapTest;

import java.util.HashMap;

public class LRUCache {
    class Node {
        int key, value;
        Node next, pre;
        public Node (int key, int val) {
            this.key = key;
            this.value = val;
            next = pre = null;
        }
    }

    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = tail = null;
    }

    public void put(int key, int value) {
        Node node = map.get(key);

        if (node != null) {
            node.value = value;
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
            }
        } else {
            Node newNode = new Node(key, value);
            if (capacity == 0) {
                Node temp = head;
                head = head.next;
                map.remove(temp.key);
                capacity++;
            }
            if (head == null && tail == null) {
                head = newNode;
            } else {
                tail.next= newNode;
                newNode.pre = tail;
                newNode.next = null;
            }
            tail = newNode;
            map.put(key, newNode);
            capacity--;
        }
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        if (node != tail) {
            if (node == head) {
                head = head.next;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        }
        return node.value;
    }

    public void print() {
        if (head == null && tail == null)
            System.out.println("This is an empty cache!");
        Node cur = head;
        while (cur != null) {
            System.out.print("{ key : " + cur.key + ", value : " + cur.value + " } <==>");
            cur = cur.next;
        }
        System.out.println("null");
    }

}
