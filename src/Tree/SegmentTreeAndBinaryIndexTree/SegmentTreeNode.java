package Tree.SegmentTreeAndBinaryIndexTree;

public class SegmentTreeNode {
    int start , end, sum;
    SegmentTreeNode left, right;
    public SegmentTreeNode(int start, int end, int sum) {
        this.start = start;
        this.end = end;
        this.sum = sum;
        this.left = this.right = null;
    }
}
