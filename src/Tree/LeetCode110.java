package Tree;

import Tree.traversal.TreeNode;

public class LeetCode110 {
    public boolean isBalanced(TreeNode node) {
        return helper(node) != -1;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        int l = helper(node.left);
        int r = helper(node.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }
}
