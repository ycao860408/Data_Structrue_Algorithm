package sortingAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class sortingAlgorithm {
    public static void bubbleSort(int[] nums) {
        boolean change;
        while (true) {
            change = false;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i - 1];
                    nums[i - 1] = temp;
                    change = true;
                }
                //System.out.println(Arrays.toString(nums));
            }
            //System.out.println(Arrays.toString(nums));
            if (!change) {
                break;
            }
        }
    }

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void insertSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int newValue = nums[i];
            int j = i -1 ;
            while (j >= 0 && nums[j] >= newValue) {
                nums[j + 1] = nums[j];
                j--;
            }
            nums[j + 1] = newValue;
        }
    }

    public static void mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        helper(0, nums.length - 1, nums, temp);
    }

    private static void helper(int start, int end, int[] nums, int[] temp) {
        if (start >= end) return;
        int mid = start + (end - start) / 2;
        helper(start, mid, nums, temp);
        helper(mid + 1, end, nums, temp);
        int i = start, j = mid + 1;

        for (int k = 0; k < end - start + 1; k++) {
            if (i <= mid && (j > end||nums[i] < nums[j])) {
                temp[k] = nums[i++];
            } else {
                temp[k] = nums[j++];
            }
        }

        for (int k = start; k <= end; k++) {
            nums[k] = temp[k - start];
        }
    }

    public static void quickSort(int[] num) {
        qhelper(0, num.length - 1, num);
    }

    private static void qhelper(int start, int end, int[] nums) {
        if (start >= end) return;

        int pivot = nums[start + (int)(Math.random() * (end - start))];
        int i = start, j = end;

        while (i <= j) {
            while (i <= j && nums[i] < pivot) {
                i++;
            }

            while (i <= j && nums[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = nums[i];
                nums[i++] = nums[j];
                nums[j--] = temp;
            }
        }
        qhelper(start, j, nums);
        qhelper(i, end, nums);
    }

    public static void countSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int [] count = new int[max + 1];
        for (int num : nums) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] != 0) {
                nums[index++] = i;
                count[i]--;
            }
        }
    }

    public static void bucketSort(int[] nums) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        int bucketNum = (max - min) / nums.length + 1;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < bucketNum; i++) {
            buckets.add(new ArrayList<>());
        } 
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - min) / nums.length;
            buckets.get(index).add(nums[i]);
        }
        for (List<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        int nitem = 0;
        for (List<Integer> bucket : buckets) {
            for (int item : bucket) {
                nums[nitem] = item;
                nitem++;
            }
        }

    }


    public static void main(String[] args) {
        int[] test = new int[] {3, 1, 5, 2, 4, 6, 8, 0};
        int[] temp;
        /*bubbleSort(temp = Arrays.copyOf(test, test.length));
        System.out.println(Arrays.toString(temp));
        selectionSort(temp = Arrays.copyOf(test, test.length));
        System.out.println(Arrays.toString(temp));
        insertSort(temp = Arrays.copyOf(test, test.length));
        System.out.println(Arrays.toString(temp));*/
        mergeSort(temp = Arrays.copyOf(test, test.length));
        System.out.println(Arrays.toString(temp));
        quickSort(temp = Arrays.copyOf(test, test.length));
        System.out.println(Arrays.toString(temp));
        countSort(temp = Arrays.copyOf(test, test.length));
        System.out.println(Arrays.toString(temp));
        bucketSort(temp = Arrays.copyOf(test, test.length));
        System.out.println(Arrays.toString(temp));
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }
        System.out.println(list.set(0, 4));
        Integer[] temp2 = new Integer[test.length];
        for(int i = 0; i < test.length; i++) {
            temp2[i] = test[i];
        }
        Arrays.sort(temp2, Collections.reverseOrder());
        System.out.println(Arrays.toString(temp2));
    }
}
