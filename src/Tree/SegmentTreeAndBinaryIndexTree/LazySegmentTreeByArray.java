package Tree.SegmentTreeAndBinaryIndexTree;

import java.util.Arrays;

public class LazySegmentTreeByArray {
    public  int[] tree;
    public  int[] lazy;
    private int length;
    public LazySegmentTreeByArray(int [] nums) {
        if (nums == null || nums.length == 0) return;
        this.tree = new int[4 * nums.length];
        this.lazy = new int[tree.length];
        this.length = nums.length - 1;
        buildTree(nums, 0, nums.length - 1, 0);
    }

    private int buildTree(int[] nums, int start, int end, int idx) {
        if (start == end) {
            return tree[idx] = nums[start];
        }
        int mid = start + (end - start) / 2;
        int left = buildTree(nums, start, mid, 2 * idx + 1);
        int right = buildTree(nums, mid + 1, end, 2 * idx + 2);
        return tree[idx] = left + right;
    }

    public void updateRange(int diff, int lower, int upper) {
        updateRange(diff, 0, this.length, 0, lower, upper);
    }

    private void updateRange(int diff, int start, int end, int idx,  int lower, int upper) {
        if (lazy[idx] != 0) {
            tree[idx] += (end - start + 1) * this.lazy[idx];
            if (end != start) {
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }
            lazy[idx] = 0;
        }
        if (start > end || start > upper || end < lower) return;

        if (start >= lower && end <= upper) {
            tree[idx] += (end - start+ 1) * diff;
            if (end != start) {
                lazy[2 * idx + 1] += diff;
                lazy[2 * idx + 2] += diff;
            }
            return;
        }
        int mid = start + (end - start) / 2;
        updateRange(diff, start, mid, 2 * idx + 1, lower, upper);
        updateRange(diff, mid + 1, end, 2 * idx + 2 , lower, upper);
        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
    }

    public int rangeSum(int start, int end) {
        if (start > end || start < 0 || end > this.length) return -1;
        return rangeSum(0, length, 0, start, end);
    }

    private int rangeSum(int curStart, int curEnd, int idx, int start, int end ) {
        if (lazy[idx] != 0) {
            tree[idx] += (curEnd - curStart + 1) * lazy[idx];
            if (curEnd != curStart) {
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }
            lazy[idx] = 0;
        }

        if (curStart > curEnd || curStart > end || curEnd < start) return 0;

        if (curStart >= start && curEnd <= end) return tree[idx];

        int mid = curStart + (curEnd - curStart) / 2;
        return rangeSum(curStart, mid, 2 * idx + 1, start, end) + rangeSum(mid + 1, curEnd, 2 * idx + 2, start, end);
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        LazySegmentTreeByArray ls = new LazySegmentTreeByArray(arr);
        System.out.println(ls.rangeSum(1, 3));
        //System.out.println(Arrays.toString(ls.tree));
        ls.updateRange(10, 1, 5);
        System.out.println(ls.rangeSum(1, 3));
        //System.out.println(Arrays.toString(ls.tree));
    }
}
