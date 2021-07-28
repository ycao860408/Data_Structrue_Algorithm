package Tree.AVL.impl;

import Tree.AVL.AVLNode;
import Tree.AVL.IAVLTree;


import java.util.LinkedList;
import java.util.Queue;

public class AVLTreeImpl implements IAVLTree {

    private AVLNode root;
    private int size;

    public AVLTreeImpl() {
        this.root = null;
        this.size = 0;
    }

    @Override
    public void add(int val) {
        this.root = add(this.root, val);
    }

    private AVLNode add(AVLNode node, int val) {
        if (node == null) {
            this.size++;
            return new AVLNode(val);
        }

        if (node.val == val) throw new IllegalArgumentException("Value already exists!");

        if (node.val > val) {
            node.left = add(node.left, val);
        } else {
            node.right = add(node.right, val);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balanceFactor = getBalanaceFactor(node);

        if (balanceFactor > 1 && getBalanaceFactor(node.left) > 0) {
            return rightRotation(node);    //LL
        } else if (balanceFactor < -1 && getBalanaceFactor(node.right) < 0) {
            return leftRotation(node);     //RR
        } else if (balanceFactor > 1 && getBalanaceFactor(node.left) <= 0) {
            node.left = leftRotation(node.left); // LR
            return rightRotation(node);
        } else if (balanceFactor < -1 && getBalanaceFactor(node.right) >= 0) {
            node.right = rightRotation(node.right);  // RL
            return leftRotation(node);
        }

        return node;
    }

    private AVLNode rightRotation(AVLNode node) {
        AVLNode x = node.left;
        AVLNode y = x.right;

        x.right = node;
        node.left = y;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    private AVLNode leftRotation(AVLNode node) {
        AVLNode x = node.right;
        AVLNode y = x.left;

        x.left = node;
        node.right = y;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    private int getHeight(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    private int getBalanaceFactor(AVLNode node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    public  boolean isBST( ) {
        return isBST(this.root);
    }

    private boolean isBST(AVLNode node) {
        return helper(node, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean helper(AVLNode node, int upper, int lower) {
        if (node == null) return true;
        if (node.val >= upper || node.val <= lower) return false;
        boolean left = helper(node.left, node.val, lower);
        boolean right = helper(node.right, upper, node.val);
        return left && right;
    }
    // based on leetcode, but do not necessary to do that, because we have a height field!
    public boolean isBalanced() {
       return isBalanced(this.root);
    }


    private boolean isBalanced(AVLNode node) {
        return helper(node) != -1;
    }

    private int helper(AVLNode node) {
        if ( node == null) return 0;
        int l = helper(node.left);
        int r = helper(node.right);
        if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
            return -1;
        }
        return Math.max(l, r) + 1;
    }

    // isbalanced based on avlNode.height!!!!!

    public boolean isBalanced2() {
        return helper2(this.root);
    }

    private boolean helper2(AVLNode node) {
        if (node == null) return true;
        if (node.left == null && root.right == null) return true;
        else if (node.left != null && node.right != null) return Math.abs(node.left.height - node.right.height) <= 1;
        else if (node.left != null) return node.left.height <= 1;
        else return node.right.height <= 1;
    }

    @Override
    public void remove(int val) {
        this.root = remove(this.root, val);
    }

    private AVLNode remove(AVLNode node, int val) {
        if (node == null) return null;
        AVLNode changeNode = null;
        if (val < node.val) {
            node.left = remove(node.left, val);
            changeNode = node;
        } else if (val > node.val) {
            node.right = remove(node.right, val);
            changeNode = node;
        } else {

            if (node.left == null && node.right == null) {
                this.size--;
                changeNode = null;
            } else if (node.left != null && node.right != null) {
                AVLNode candidate = node.right;
                while (candidate.left != null) {
                    candidate = candidate.left;
                }
                node.val = candidate.val;
                node.right = remove(node.right, candidate.val);
                changeNode = node;
            } else if (node.left != null) {
                this.size--;
                changeNode = node.left;
            } else {
                this.size--;
                changeNode =  node.right;
            }
        }

        if (changeNode == null) return null;

        changeNode.height = 1 + Math.max(getHeight(changeNode.left), getHeight(changeNode.right));
        int balanceFactor = getBalanaceFactor(changeNode);

        if (balanceFactor > 1 && getBalanaceFactor(changeNode.left) > 0) {
            return rightRotation(changeNode);    //LL
        } else if (balanceFactor < -1 && getBalanaceFactor(changeNode.right) < 0) {
            return leftRotation(changeNode);     //RR
        } else if (balanceFactor > 1 && getBalanaceFactor(changeNode.left) <= 0) {
            changeNode.left = leftRotation(changeNode.left); // LR
            return rightRotation(changeNode);
        } else if (balanceFactor < -1 && getBalanaceFactor(changeNode.right) >= 0) {
            changeNode.right = rightRotation(changeNode.right);  // RL
            return leftRotation(changeNode);
        }

        return changeNode;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    public void print() {
        int level = 0;
        Queue<AVLNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            level++;
            System.out.println("Level " + level + ":");
            for (int i = 0; i < size; i++) {
                AVLNode cur = que.poll();
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

    @Override
    public boolean contains(int val) {
        return contains(this.root, val);
    }

    private boolean contains(AVLNode node, int val) {
        if (node == null) return false;
        if (node.val == val) return true;
        if (val < node.val) {
            return contains(node.left, val);
        } else {
            return contains(node.right, val);
        }
    }

    public static void main(String[] args) {
        AVLTreeImpl avlTree = new AVLTreeImpl();
        avlTree.add(8);
        avlTree.add(5);
        avlTree.add(6);
        //avlTree.print();
        avlTree.add(3);
        avlTree.add(10);
        avlTree.add(9);
        avlTree.add(11);
        avlTree.add(2);
        //avlTree.add(1);
        avlTree.remove(11);
        System.out.println(avlTree.isBST());
        System.out.println(avlTree.isBalanced());
        System.out.println(avlTree.isBalanced2());
        avlTree.print();
        System.out.println("size: " + avlTree.size());
        System.out.println(avlTree.contains(6));
    }
}
