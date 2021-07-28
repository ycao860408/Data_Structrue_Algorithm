import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.LinkedList;
public class ArrayLIstDemo {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        System.out.println(Arrays.toString(arr.toArray()));
        arr.remove(2);
        System.out.println(Arrays.toString(arr.toArray()) + " " + arr.size());
        arr.add(0, 14);
        System.out.println(Arrays.toString(arr.toArray()) + " " + arr.size());
        arr.add(1, 15);
        System.out.println(Arrays.toString(arr.toArray()) + " " + arr.size());
    }
}
