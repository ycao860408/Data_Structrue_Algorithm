package Tree.SegmentTreeAndBinaryIndexTree;

public class BinaryIndexTree {
    private int []nums;
    private int []tree;

    public BinaryIndexTree(int[] nums) {
        this.tree = new int[nums.length + 1];
        this.nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int idx, int val) {
        int diff = val - nums[idx];
        nums[idx] = val;
        for (int i = idx + 1; i < tree.length; i += lowbit(i)) {
            tree[i] += diff;
        }
    }

    public int sumRange(int start, int end) {
        return sum(end) - sum(start - 1);
    }

    private int sum(int idx) {
        int sum = 0;
        for (int i = idx + 1; i > 0 ; i -= lowbit(i)) {
            sum += tree[i];
        }
        return sum;
    }

    private int lowbit(int num) {
        return num & (-num);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        BinaryIndexTree bit = new BinaryIndexTree(nums);
        System.out.println(bit.sumRange(1, 4));
        //'System.out.println(-5 >>2);
        //System.out.println(-5 >>> 2);
    }

}
