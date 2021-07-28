import java.util.BitSet;

public class BitMap {

    public static void bitSet() {
        BitSet bitSet = new BitSet();
        System.out.println(bitSet.size());
        bitSet.set(0);
        System.out.println(bitSet.size());
        System.out.println(bitSet.get(0));
    }

    public static boolean isUniqueChars(String str) {
        if (str.length() > 256) return false;
        int checker = 0;

        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        bitSet();
        System.out.println(isUniqueChars("abc"));
        System.out.println(isUniqueChars("cabc"));
    }
}
