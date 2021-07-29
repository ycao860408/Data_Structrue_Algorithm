package Heap.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinHeapWithDeleting {
    private PriorityQueue<Integer> pq;
    private Map<Integer, Integer> map;
    private Integer size;

    public MinHeapWithDeleting() {
        pq = new PriorityQueue<>();
        map = new HashMap<>();
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Integer size() {
        return size;
    }

    public void offer(Integer item) {
        if (map.containsKey(item)) {
            map.put(item, map.get(item) + 1);
        } else {
            map.put(item, 1);
            pq.offer(item);
        }
        size++;
    }

    public Integer poll() {
        lazyDelete();
        Integer item = pq.peek();
        if (item != null) delete(item);
        if (!map.containsKey(item)) pq.poll();
        return item;
    }

    public Integer top() {
        lazyDelete();
        return pq.peek();
    }

    public void lazyDelete() {
        while (!pq.isEmpty() && !map.containsKey(pq.peek())) {
            pq.poll();
        }
    }

    public boolean delete(Integer item) {
        if (!map.containsKey(item)) return false;
        Integer num = map.get(item);
        if (num == 1) {
            map.remove(item);
        } else {
            map.put(item, map.get(item) - 1);
        }
        size--;
        return true;
    }
}
