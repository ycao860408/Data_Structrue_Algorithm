package Tree.BinarySearchTree.BInarySearchTreeImpl;

import Tree.BinarySearchTree.IBinarySearchTree;
import Tree.BinarySearchTree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTreeImpl implements IBinarySearchTree {
    private TreeNode root;
    private int size;

    public BinarySearchTreeImpl() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(int val) {
        this.root = addEle(val, this.root);
    }

    private  TreeNode addEle(int val, TreeNode node) {
        if (node == null) {
            this.size++;
            return new TreeNode(val);
        }
        if (val == node.val) {
            throw new IllegalArgumentException("Element existed!");
        }
        if (val < node.val) {
            node.left = addEle(val, node.left);
        } else {
            node.right = addEle(val,node.right);
        }
        return node;
    }

    @Override
    public void remove(int val) {
        this.root = remove(this.root, val);
    }

    private TreeNode remove(TreeNode node, int val) {
        if (node == null) return null;
        if (val < node.val) {
            node.left = remove(node.left, val);
        } else if (val > node.val) {
            node.right = remove(node.right, val);
        } else {

            if (node.left == null && node.right == null) {
                this.size--;
                return null;
            } else if (node.left != null && node.right != null) {
                TreeNode candidate = node.right;
                while (candidate.left != null) {
                    candidate = candidate.left;
                }
                node.val = candidate.val;
                node.right = remove(node.right, candidate.val);
            } else if (node.left != null) {
                this.size--;
                return node.left;
            } else {
                this.size--;
                return node.right;
            }
        }
        return node;
    }

    @Override
    public boolean contains(int val) {
        return containsEle(val, root);
    }

    private boolean containsEle(int val, TreeNode node) {
        if (node == null) return false;
        if (node.val == val) return true;
        if (val < node.val) {
            return containsEle(val, node.left);
        } else {
            return containsEle(val, node.right);
        }
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    private void print() {
        int level = 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            level++;
            System.out.println("Level " + level + ":");
            for (int i = 0; i < size; i++) {
                TreeNode cur = que.poll();
                System.out.print(cur.val);
                if (cur.left != null) {
                    que.offer(cur.left);
                    System.out.println(" 's left child: " + cur.left.val);
                }
                if (cur.right != null) {
                    que.offer(cur.right);
                    System.out.println(" 's right child: " + cur.right.val);
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BinarySearchTreeImpl bst = new BinarySearchTreeImpl();
        bst.add(8);
        bst.add(5);
        bst.add(6);
        bst.add(3);
        bst.add(10);
        bst.add(9);
        bst.add(11);
        System.out.println(bst.size());
        //bst.print();
        //System.out.println(bst.contains(6));
        //System.out.println(bst.contains(0));
        bst.remove(8);
        System.out.println(bst.size());
        //bst.print();
        bst.remove(11);
        System.out.println(bst.size());
    }
}
