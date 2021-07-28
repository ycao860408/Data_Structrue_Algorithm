package HashTable.Function;

import HashTable.OpenAddressing.impl.HashTableOpenAddressing;

import java.util.*;

public class FunctionAndTransversal {
    public static  void function(String[] dict) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (String str : dict) {
            map1.put(str, map1.getOrDefault(str, 0) + 1);
            map2.putIfAbsent(str, 0);
            map2.put(str, map2.get(str) + 1);
        }

        System.out.println(map1.toString());
        System.out.println(map2.toString());
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"abc","abc", "ac","bc","cd","bc","cd"};
        function(strs);
        int[] nums = new int[] {1, 2, 3, 4};
        HashMap<Integer, Integer> map = new HashMap<>();
        Hashtable<Integer, Integer> table = new Hashtable<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
            table.put(nums[i],i);
            set.add(nums[i]);
        }

        System.out.println("HashMap");
        for (Integer key : map.keySet()) {
            System.out.println(key + " " + map.get(key));
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            System.out.println(key + " " + value);
        }

        for (Integer num : map.values()) {
            System.out.println(num);
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        System.out.println("HashTable");

        for (Integer key : table.keySet()) {
            System.out.println(key + " : " + table.get(key));
        }

        System.out.println();
        Enumeration<Integer> enumeration1 = table.keys();
        while (enumeration1.hasMoreElements()) {
            int key = enumeration1.nextElement();
            System.out.println(key + " : " + table.get(key));
        }

        System.out.println();
        Enumeration<Integer> enumeration2 = table.elements();// 出来value！！！

        while (enumeration2.hasMoreElements()) {
            int value = enumeration2.nextElement();
            System.out.print(value + " ");
        }
        System.out.println();
        System.out.println();
        Iterator<Map.Entry<Integer, Integer>> iterator1 = table.entrySet().iterator();

        while (iterator1.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator1.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("HashSet");

        for (Integer item : set) {
            System.out.println(item);
        }
        System.out.println();
        Iterator<Integer> iterator2 = set.iterator();

        while (iterator2.hasNext()) {
            Integer num = iterator2.next();
            System.out.println(num);
        }
    }
}
