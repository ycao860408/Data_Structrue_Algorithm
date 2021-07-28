package String;

import java.util.Arrays;

public class Function {
    public static void function() {
        /*String s1= "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));*/

        String s = "banana";
        System.out.println(s.substring(1));
        System.out.println(s.indexOf("na"));
        System.out.println(s.lastIndexOf("na"));

        for (char c : s.toCharArray()) {
            System.out.print(c + " ");
        }
        System.out.println();

        String[] strs = s.split("n");
        System.out.println(Arrays.toString(strs));

        int num = 11;
        String valOf = String.valueOf(num);
        System.out.println(valOf);
        System.out.println(Integer.parseInt(valOf));
        System.out.println(Double.parseDouble(valOf));
        String str = "a//b/c";
        String[] split = str.split("/+");
        System.out.println(Arrays.toString(split));
        String[] split1 = str.split("/");
        System.out.println(Arrays.toString(split1));
        System.out.println("a\\b\\c");
        split1 = "a\\b\\c".split("\\\\");
        System.out.println(Arrays.toString(split1));
    }

    public static void main(String[] args) {
        function();
    }
}
