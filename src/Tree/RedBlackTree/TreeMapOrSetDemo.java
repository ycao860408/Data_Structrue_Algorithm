package Tree.RedBlackTree;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapOrSetDemo {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();

        map.put(1, 5);
        map.put(5, 5);
        map.put(2, 5);
        map.put(4, 6);
        map.put(3, 5);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("key: " +  entry.getKey() + ",  value: " + entry.getValue());
        }
        System.out.println(map.ceilingKey(3));
        System.out.println(map.floorKey(3));
        System.out.println(map.higherKey(3));
        System.out.println(map.lowerKey(3));
        Map.Entry<Integer, Integer> entry = map.higherEntry(3);
        System.out.println(entry.getValue());
    }
}
