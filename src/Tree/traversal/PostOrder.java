package Tree.traversal;

import jdk.nashorn.api.tree.Tree;

import java.util.*;

public class PostOrder {
    public void postOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        System.out.println(Arrays.toString(res.toArray()));
    }

    private void helper(TreeNode node, List<Integer> res) {
        if (node == null) return;
        helper(node.left, res);
        helper(node.right, res);
        res.add(node.val);
    }

    private class Point {
        int time;
        TreeNode node;
        public Point(TreeNode node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public void posOrder2(TreeNode root) {
        if (root == null) return;
        LinkedList<Integer> res = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
            res.addFirst(cur.val);
        }
        System.out.println(Arrays.toString(res.toArray()));
    }

    public void postOrder3(TreeNode root) {
        if (root == null) return;
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
                cur.time++;
                if (cur.node.right != null) {
                    stack.push(new Point(cur.node.right, 1));
                }
            } else {
                res.add(cur.node.val);
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
        PostOrder po = new PostOrder();
        po.postOrder(root);
        po.posOrder2(root);
        po.postOrder3(root);
    }
}
