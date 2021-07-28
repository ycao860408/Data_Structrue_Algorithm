package Tree.traversal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class InOrder {
    public void inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        System.out.println(Arrays.toString(res.toArray()));
    }

    private void helper(TreeNode node, List<Integer> res) {
        if (node == null) return;
        helper(node.left, res);
        res.add(node.val);
        helper(node.right, res);
    }

    public void inOrder2(TreeNode root) {
        if (root == null) return;
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        System.out.println(Arrays.toString(res.toArray()));
    }

    private class Point {
        int time;
        TreeNode node;
        public Point(TreeNode node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public void inOrder3(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(root, 1));
        while (!stack.isEmpty()) {
            Point cur = stack.peek();
            if (cur.time == 1) {
                cur.time++;
                if (cur.node.left != null) {
                    stack.push(new Point(cur.node.left, 1));
                }
            } else if (cur.time == 2) {
                res.add(cur.node.val);
                cur.time++;
                if (cur.node.right != null) {
                    stack.push(new Point(cur.node.right, 1));
                }
            } else {
                stack.pop();
            }
        }
        System.out.println(Arrays.toString(res.toArray()));
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(5);
        TreeNode t5 = new TreeNode(1);
        TreeNode t6 = new TreeNode(7);
        TreeNode t7 = new TreeNode(2);
        TreeNode t8 = new TreeNode(10);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        t3.left = t7;
        t3.right = t8;
        InOrder iO = new InOrder();
        iO.inOrder(root);
        iO.inOrder2(root);
        iO.inOrder3(root);
    }
}
