package HashTable.LinkedHashMapTest;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String, String> lm =  new LinkedHashMap<>(16, .75f, true);
        lm.put("1", "1");
        lm.put("2", "1");
        lm.put("3", "1");
        lm.put("4", "1");
        lm.put("5", "1");
        lm.put("6", "1");
        print(lm);
        lm.get("1");
        print(lm);
    }

    public static void print(LinkedHashMap<String, String> lm) {
        for (Map.Entry<String, String> entry: lm.entrySet()) {
            System.out.print(entry.getKey() + "\t");
        }
        System.out.println();
    }

}
