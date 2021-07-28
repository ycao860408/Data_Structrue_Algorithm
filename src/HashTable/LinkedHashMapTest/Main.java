package HashTable.LinkedHashMapTest;

public class Main {
    public static void main(String[] args) {
        //LRUCache cache = new LRUCache(5);
        MyLRUCache cache = new MyLRUCache(2);
        cache.put(1, 1);
        cache.print();
        //System.out.println(cache.size() + " " +cache.capacity());
        cache.put(2, 1);
        cache.print();
        cache.get(1);
        cache.print();
        cache.put(3, 1);
        System.out.println(cache.get(2));
        cache.print();
        cache.put(4, 5);
        cache.put(5, 8);
        cache.print();
        cache.put(0, -1);
        cache.print();


    }
}
