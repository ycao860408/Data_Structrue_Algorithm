package Tree.SegmentTreeAndBinaryIndexTree;

public class  SegmentTreeByTreeNode {
    SegmentTreeNode root;

    public SegmentTreeByTreeNode(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }

    private SegmentTreeNode buildTree(int[] num, int start, int end) {
        if (start > end) return null;
        if (start == end) {
            return new SegmentTreeNode(start, end, num[start]);
        }
        int mid = start + (end - start) / 2;
        SegmentTreeNode res = new SegmentTreeNode(start, end, 0);
        res.left = buildTree(num, start, mid);
        res.right = buildTree(num, mid + 1, end);
        if (res.left != null) {
            res.sum  += res.left.sum;
        }
        if (res.right != null) {
            res.sum += res.right.sum;
        }
        return res;
    }

    public void update(int i, int val) {
        this.root = update(this.root, i, val);
    }
    private SegmentTreeNode update(SegmentTreeNode node, int pos, int val) {
        if (node.start == pos && node.end == pos) {
            node.sum = val;
            return node;
        }

        int mid = node.start + (node.end - node.start) / 2;
        if (node.start <=  pos && pos <= mid) {
            node.left = update(node.left, pos, val);
        }
        if (mid < pos && pos <= node.end) {
            node.right = update(node.right, pos, val);
        }

        node.sum = node.right.sum + node.right.sum;
        return node;
    }

    public int sumRange(int i, int j) {
        return sumRange(this.root, i, j);
    }

    private int sumRange(SegmentTreeNode node, int start, int end) {
        if (node.start == start && node.end == end) {
            return node.sum;
        }

        int mid = node.start + (node.end - node.start) / 2;
        int leftSum = 0, rightSum = 0;
        if (start <= mid) {
            if (mid < end) {
                leftSum = sumRange(node.left, start, mid);
            } else {
                leftSum = sumRange(node.left, start, end);
            }
        }

        if (mid < end) {
            if (start <= mid) {
                rightSum = sumRange(node.right, mid + 1, end);
            } else {
                rightSum = sumRange(node.right, start, end);
            }
        }
        return leftSum + rightSum;
    }


}
