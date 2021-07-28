package stack;

import jdk.dynalink.beans.StaticClass;

public class StackIterator {
    public static int sum = 0;

    public static void sumOfN(int num) {
        if (num == 0) return;
        sum += num;
        sumOfN(num - 1);
    }

    public static int sumOfN2(int num) {
        if (num == 0)
            return 0;

        return num + sumOfN2(num - 1);
    }

    public static int iteration(int num) {
        int sum = 0;

        while (num >= 0) {
            sum += num;
            num--;
        }
        return sum;
    }

    public static void main(String[] args) {
        sumOfN(10);
        System.out.println(sum);
        System.out.println(sumOfN2(10));
        System.out.println(iteration(10));
    }
}
