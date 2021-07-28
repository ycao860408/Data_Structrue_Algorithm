
import java.util.Arrays;
public class ArrayDemo {
    public static void main(String [] args) {
        //int[] arr = new int[10];
        int[] arr2 = new int[] {1, 2, 3};
        System.out.println(Arrays.toString(arr2));
        arr2[0] = 77;
        System.out.println(Arrays.toString(arr2));
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }

        int[][] arr1 = new int[][] {
                {1, 2, 3},
                {2, 3, 4}
        };

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                System.out.println(arr1[i][j]);
            }
        }
    }
}
