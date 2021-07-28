package stack;

public class InnerCallAndStack {
    public static void test() {
        test1();
    }

    public static void test1() {
        System.out.println("test1 starts");
        test2();
        System.out.println("test1 ends");
    }

    public static void test2() {
        System.out.println("test2 starts");
        test3();
        System.out.println("test2 ends");
    }

    public static void test3() {
        System.out.println("test3 starts");
        System.out.println("test3 ends");
    }

    public static void main(String[] args) {
        test();
    }
}
