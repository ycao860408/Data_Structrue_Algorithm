package JAVABASIC;

public class UndeterminedArgumentDemo {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {6, 7, 8, 9, 0};
        print(arr1);
        print(arr2);
        print(77, 22, 33, 66, 100);
        method(12, 2.4, 33, 4, 55);
        char[] c  = new char[]{1, 2, 3, 4, 5, 6};
        System.out.println(c);
    }

    public static void print(int ... arr) {
        System.out.print("Array : [");

        for (int i = 0; i < arr.length ; i++) {
            if (i != arr.length - 1) {
                System.out.print(arr[i] + " ");
            } else {
                System.out.println(arr[i] + "]");
            }
        }
    }

    public static void method(int a, double b, int ... v) {
        System.out.println(v);
    }

}
