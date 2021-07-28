package sortingAlgorithm;

import java.util.Arrays;

//import Heap.impl.MaxHeapImpl;
public class HeapSort {
    public static void heapSort(int[] nums) {
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            heapAdjust(nums, i, nums.length);
        }

        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapAdjust(nums, 0, i);
        }
    }

    public static void heapAdjust(int[] nums, int start, int length) {
        int idx = start;

        while (true) {
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;
            int maxIndx = idx;

            if (left < length && nums[left] > nums[maxIndx]) {
                maxIndx = left;
            }

            if (right < length && nums[right] > nums[maxIndx]) {
                maxIndx = right;
            }

            if (maxIndx == idx) break;
            swap(nums, maxIndx, idx);
            idx = maxIndx;
        }
    }

    private static void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {2, 23, 30, 8, 32, 31, 41, 1,15};
        heapSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
