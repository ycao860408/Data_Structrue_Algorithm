package String;

public class StringDiff {
    private static int time = 100000;

    public static void testString() {
        String s = "";
        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            s += "cspiron";
        }

        long end = System.currentTimeMillis();
        System.out.println(s.getClass().getName() + " requires the time as " + (end - start) + " milliseconds");
    }

    public static void testStrBuffer() {
        StringBuffer sb = new StringBuffer();
        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            sb.append("cspiron");
        }

        long end = System.currentTimeMillis();
        System.out.println(sb.getClass().getName() + " requires the time as " + (end - start) + " milliseconds");
    }

    public static void testStrBuilder() {
        StringBuilder sb = new StringBuilder();
        long start = System.currentTimeMillis();
        for (int i = 0; i < time; i++) {
            sb.append("cspiron");
        }

        long end = System.currentTimeMillis();
        System.out.println(sb.getClass().getName() + " requires the time as " + (end - start) + " milliseconds");
    }

    public static void main(String[] args) {
        testString();
        testStrBuilder();
        testStrBuffer();
    }
}
