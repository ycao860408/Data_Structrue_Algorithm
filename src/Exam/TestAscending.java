package Exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class TestAscending {
/*
*   ascending: 1, 2, 3, 3, 5, 6, 7
*
*   strictly ascending: 1, 2, 3, 4, 5, 6
*
* # (arr[i - 1] > arr[i]) == 0  <==> ascending
* # (arr[i - 1] == arr[i]) == 0 <==> strictly ascending
*
*   descending:   7, 6, 5, 5, 4, 2, 2, 1
*
*   strictly descending: 7, 6, 5, 4, 2, 1
*
* #(arr[i - 1] < arr[i]) == 0 <==> descending
* #(arr[i - 1] == arr[i]) == 0 <==> strictly descending
*
*
*   hard to determine:
*          case 1:  1
*          case 2: 1 3 2 4 6 4
* #(arr[i - 1] > arr[i]) > 0 && #(arr[i - 1] < arr[i]) > 0 <==> hard to determine
*   constant array:  1 1 1 1 1 1 1 1
*
* #(arr[i - 1] < arr[i]) == 0 && #(arr[i - 1] > arr[i] == 0) ==0 <==> constant array
*
* */
    final static private int GREAT = 0;
    final static private int EQUAL = 1;
    final static private int LESS = 2;

    public static String featureOfArray(int[] arr) {
        // edge case:

        if (arr == null || arr.length == 0)
            throw new IllegalArgumentException("Invalid input!");

        if (arr.length == 1)
            throw new IllegalArgumentException("Hard to determine!");

        int[] count = new int[3];
        checkTrend(count, arr);

        String result ="";

        if (count[GREAT] == 0 && count[LESS] == 0) {
            throw new IllegalArgumentException("Constant Array!");
        } else if(count[GREAT] != 0 && count[LESS] != 0) {
            throw new IllegalArgumentException("Hard to determine!");
        } else if (count[GREAT] == 0) {
            result = count[EQUAL] == 0 ? "Strictly Descending!" : "Descending!";
        } else {
            result = count[EQUAL] == 0 ? "Strictly Ascending!" : "Ascending!";
        }
        return result;
    }

    public static void checkTrend(int[] count, int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                count[GREAT]++;
            } else if (arr[i] < arr[i - 1]) {
                count[LESS]++;
            } else {
                count[EQUAL]++;
            }
            if (count[GREAT] > 0 && count[LESS] > 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        int [] testcase1 = new int[] {1, 2, 3, 4, 5, 6, 7};
        int [] testcase2 = new int[] {7, 6, 5, 4, 3, 2, 1};
        int [] testcase3 = new int[] {1, 2, 3, 4, 4, 3, 2, 1};
        int [] testcase4 = new int[] {1, 2, 3, 3, 4, 5, 5, 6};
        //int [] testcase5 = new int[] {1};
        int [] testcase6 = new int[] {1, 1, 1, 1, 1, 1, 1, 1};
        try {
            System.out.println(featureOfArray(testcase1));
            System.out.println(featureOfArray(testcase2));
            System.out.println(featureOfArray(testcase3));
            System.out.println(featureOfArray(testcase4));
            //System.out.println(featureOfArray(testcase5));
            //System.out.println(featureOfArray(testcase6));
            //System.out.println(featureOfArray(new int[0]));
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        Integer[] temp = new Integer[] {1, 2, 3, 4, 5, 6};
        List<Integer> res = Arrays.asList(1, 2, 3, 4);
        System.out.println(res.toString());

        String[] haha = new String[] {"123", "234","1","567","2"};
        Arrays.sort(haha, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return s2.compareTo(s1);
            }
        });
        System.out.println(Arrays.toString(haha));
    }
}
