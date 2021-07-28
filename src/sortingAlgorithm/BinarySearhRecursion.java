package sortingAlgorithm;
import java.util.Arrays;
import java.util.Collections;
public class BinarySearhRecursion {
    public static int binarySearch1(int[] nums, int low, int high, int target) {

        if (low + 1 == high) {
            if (nums[high] == target) return high;
            else if (nums[low] == target) return low;
            else return -1;
        }

        int mid = low + (high - low) / 2;
        if (nums[mid] > target) {
            return binarySearch1(nums, low, mid, target);
        } else if (nums[mid] < target) {
            return binarySearch1(nums, mid, high, target);
        } else {
            return mid;
        }
    }

    public static int binarySearch2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left + 1 == right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }

        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(binarySearch1(nums, 0, nums.length - 1, -1));
        System.out.println(Arrays.binarySearch(nums, -1));

    }
}
