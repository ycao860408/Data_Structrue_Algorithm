package stack;

public class StackRecusionLevel {
    private static int level = 0;
    public static void test() {
        level++;
        test();
    }

    public static void main(String[] args) {
        try {
            test();
        } catch (StackOverflowError e) {
            System.out.println(level);
        }
    }
}
