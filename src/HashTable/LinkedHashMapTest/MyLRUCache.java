package HashTable.LinkedHashMapTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyLRUCache {
    private class ListNode {
        int key, value;
        ListNode pre, next;
        public ListNode(int key, int value) {
            this.key = key;
            this.value = value;
            this.pre = this.next = null;
        }
    }

    private int capacity;
    private ListNode head, tail;
    Map<Integer, ListNode> map;

    public MyLRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = tail = new ListNode(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public void put(int key, int value) {
        if (this.get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        if (map.size() == capacity) {
            map.remove(head.next.key);
            ListNode newFirst = head.next.next;
            head.next = newFirst;
            newFirst.pre = head;
        }

        ListNode newNode = new ListNode(key, value);
        map.put(key, newNode);
        putToEnd(newNode);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        ListNode targetNode = map.get(key);
        targetNode.pre.next = targetNode.next;
        targetNode.next.pre = targetNode.pre;
        putToEnd(targetNode);
        return targetNode.value;
    }

    private void putToEnd(ListNode target) {
       ListNode lastOne = tail.pre;
       lastOne.next = target;
       target.pre = lastOne;
       target.next = tail;
       tail.pre = target;
    }

    public void print() {
        if (head.next == tail)
            System.out.println("This is an empty cache!");
        ListNode cur = head.next;
        while (cur != tail) {
            System.out.print("{ key : " + cur.key + ", value : " + cur.value + " } <==>");
            cur = cur.next;
        }
        System.out.println("null");
    }


}
