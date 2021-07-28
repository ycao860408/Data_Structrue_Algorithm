package Tree.traversal;

import jdk.nashorn.api.tree.Tree;

import java.util.*;

public class LevelOrder {
    public void levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> levelResult = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = que.poll();
                levelResult.add(cur.val);
                if (cur.left != null) {
                    que.offer(cur.left);
                }
                if (cur.right != null) {
                    que.offer(cur.right);
                }
            }
            res.add(levelResult);
        }
        for (List<Integer> level : res) {
            System.out.println(Arrays.toString(level.toArray()));
        }
    }

    public void levelOrder2(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return;
        helper(root, res, 0);
        for (List<Integer> level : res) {
            System.out.println(Arrays.toString(level.toArray()));
        }
    }

    private void helper(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null) return;
        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);
        helper(node.left, res, level + 1);
        helper(node.right, res, level + 1);
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
        LevelOrder lo = new LevelOrder();
        lo.levelOrder(root);
        System.out.println();
        lo.levelOrder2(root);
    }
}
