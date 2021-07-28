package Tree.SegmentTreeAndBinaryIndexTree;

import java.util.Arrays;

public class SegmentTreeByArray {
    public int[] segmentTree;
    private int length;

    public SegmentTreeByArray(int[] nums) {
        if (nums == null || nums.length == 0) return;
        this.segmentTree = new int[4 * nums.length];
        this.length = nums.length - 1;
        buildTree(nums, 0, nums.length - 1, 0);
    }

    private int buildTree(int[] nums, int start, int end, int idx) {
        if (start == end)  {
            segmentTree[idx] = nums[start];
            return segmentTree[idx];
        }
        int mid = start + (end - start) / 2;
        int left = buildTree(nums, start, mid, idx * 2 + 1);
        int right = buildTree(nums, mid + 1, end, idx * 2 + 2);
        segmentTree[idx] = left + right;
        return segmentTree[idx];
    }

    public void update(int idx, int val) {
        update(0, this.length, 0, idx, val);
    }

    private void update(int start, int end, int idx, int pos, int val) {
        if (start == end) {
            segmentTree[idx] = val;
            return;
        }
        int mid = start + (end - start) / 2;
        if (pos <= mid) {
            update(start, mid, 2 * idx + 1, pos, val);
        }
        if (mid + 1 <= pos) {
            update(mid + 1, end, 2 * idx + 2, pos, val);
        }
        segmentTree[idx] = segmentTree[2 * idx + 1] + segmentTree[2 * idx + 2];
    }

    public int sumRange(int start, int end) {
        return sumRange(0, length, 0, start, end);
    }

    private int sumRange(int start, int end, int idx, int left, int right) {
        if (start > end || left > end || right < start) return -1;
        if (left <= start && end <= right) return segmentTree[idx];
        int mid = start + (end - start) / 2;
        if (right <= mid) {
            return sumRange(start, mid, idx * 2 + 1, left, right);
        } else if (left > mid) {
            return sumRange(mid + 1, end, idx * 2 + 2, left, right);
        } else {
            return sumRange(start, mid, idx * 2 + 1, left, right) + sumRange(mid + 1, end, idx * 2 + 2, left, right);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        SegmentTreeByArray sta = new SegmentTreeByArray(arr);
        System.out.println(Arrays.toString(sta.segmentTree));
        System.out.println(sta.sumRange(1, 3));
        sta.update(1, 10);
        System.out.println(sta.sumRange(1, 3));

    }
}
