package String;

import org.junit.Test;

public class Manacher {
    public static String getLongestPalindrome(String s) {
        String newString = preProcess(s);
        int m = newString.length();
        int [] P = new int[m];
        int r = 0, c = 0;
        for (int i = 1; i < m - 1; i++) {
            int i_mirror = 2 * c - i;
            // USE THE SYMMETRY OF THE PALINDROME, THEREFORE LENGTH OF I SHOULD BE EQUAL TO THAT OF THE I-MIRROR,
            // WHEN I_MIRROR IS OVER R, THEN IT IS AT LEAST R - I, WHETHER IT STILL HAVE ANY, YOU NEED TO EXPAND ON BOTH
            // SIDE. THIS IS WHAT IT IS GOING TO DO ON LINE 22
            if (i < r) {
                P[i] = Math.min(r - i, P[i_mirror]);
            } else {
                P[i] = 0;
            }

            while (newString.charAt(i + 1 + P[i]) == newString.charAt(i - 1 - P[i])) {
                P[i]++;
            }
            // UPDATE THE C AND R
            if (i + P[i] > r) {
                r = i + P[i];
                c = i;
            }
        }
        // WHEN YOU GET THE P ARRAY, THE (MAX INDEX - MAXVALUE) / 2 IS THE STARTING POINT
        int maxLen = 0, centerIdx = 0;
        for (int i = 1; i < m - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIdx = i;
            }
        }
        int start = (centerIdx - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }

    private static String preProcess(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() == 0) {
            sb.append("^$");
        } else {
            sb.append("^");
            for (char c : s.toCharArray()) {
                sb.append("#" + c);
            }
            sb.append("#$");
        }
        return sb.toString();
    }

    @Test
    public void test01() {
        System.out.println(Manacher.getLongestPalindrome("abcdzdcab"));
    }

}
