package Tree.RedBlackTree;

import java.util.LinkedList;
import java.util.Queue;

public class RedBlackBst<Key extends Comparable<Key>, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private boolean color; // true for red, false for black
        private int size;

        public Node(Key key, Value value, boolean color, int size) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.size = size;
        }
    }

    private Node root;

    public RedBlackBst() {

    }

    private boolean isRed(Node node) {
        if (node == null) {
            return false;
        } else {
            return node.color == RED;
        }
    }

    private int size(Node node) {
        if (node == null) return 0;
        return node.size;
    }

    public int size() {
        return size(this.root);
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("Empty");
        return get(root, key);
    }

    private Value get(Node node, Key key) {
        if (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0) {
                node = node.left;
            } else if (cmp > 0) {
                node = node.right;
            } else {
                return node.value;
            }
        }
        return null;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = x.left.color;
        x.left.color = RED;
        x.size = h.size;
        h.size = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = x.right.color;
        x.right.color = RED;
        x.size = h.size;
        h.size = size(h.right) + size(h.left) + 1;
        return x;
    }

    private void flipColor(Node h) {
        h.color = !h.color;
        h.left.color = !h.left.color;
        h.right.color = !h.right.color;
    }

    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("Empty");
        }
        this.root = put(this.root, key, value);
        this.root.color = BLACK;
    }

    private Node put(Node node, Key key, Value value) {
        if (node == null) return new Node(key, value, RED, 1);

        int cmp = key.compareTo(node.key);
        if (cmp < 0) node.left = put(node.left, key, value);
        else if (cmp > 0) node.right = put(node.right, key, value);
        else  node.value = value;

        if (isRed(node.right) && !isRed(node.left))   node = rotateLeft(node);
        if (isRed(node.left) && isRed(node.left.left)) node = rotateRight(node);
        if (isRed(node.left) && isRed(node.right)) flipColor(node);

        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void print() {
        int level = 0;
        Queue<Node> que = new LinkedList<>();
        que.offer(root);
        System.out.println("The color of the root is " +  (root.color? "Red." : "Black."));
        while (!que.isEmpty()) {
            int size = que.size();
            level++;
            System.out.println("Level " + level + ":");
            for (int i = 0; i < size; i++) {
                Node cur = que.poll();
                System.out.print(cur.key);
                if (cur.left != null) {
                    que.offer(cur.left);
                    System.out.println(" 's left child: " + cur.left.key + " and its color: " + (cur.left.color? "Red." : "Black."));
                }
                if (cur.right != null) {
                    que.offer(cur.right);
                    System.out.println(" 's right child: " + cur.right.key + " and its color: " + (cur.right.color? "Red." : "Black."));
                }
                System.out.println();
            }
            System.out.println();
        }
    }



    public void check() {
        if (!isBst()) System.out.println("This is not a BST!");
        if (!isSize()) System.out.println("The size is not right!");
        if (!is23()) System.out.println("This is not 2-3 tree!");
        if (!isBalanced()) System.out.println("This is not a black-balanced tree!");
        System.out.println("This is valid!");
    }

    private boolean isBst() {
        return helper1(this.root, null, null);
    }

    private boolean helper1(Node node, Key max, Key min) {
        if (node == null) return true;
        if (min != null && node.key.compareTo(min) <= 0) return false;
        if (max != null && node.key.compareTo(max) >= 0) return false;
        return helper1(node.left, node.key, min) && helper1(node.right, max, node.key);
    }

    private boolean isSize() {
        return helper2(this.root);
    }

    private boolean helper2(Node node) {
        if (node == null) return true;
        if (node.size != size(node.left) + size(node.right) + 1 ) {
            return false;
        }
        return helper2(node.left) && helper2(node.right);
    }

    private boolean is23() {
        return helper3(this.root);
    }

    private boolean helper3(Node node) {
        if (node == null) return true;
        if (isRed(node.right)) return false;
        if (node != null && isRed(node) && isRed(node.left)) return false;
        return helper3(node.left) && helper3(node.right);
    }

    private boolean isBalanced() {
        int black = 0;
        Node node = this.root;
        while (node != null) {
            if (!isRed(node)) {
                black++;
            }
            node = node.left;
        }
        return helper4(this.root, black);
    }

    private boolean helper4(Node node, int black) {
        if (node == null) return black == 0;
        if (!isRed(node)) black--;
        return helper4(node.left, black) && helper4(node.right, black);
    }



    public static void main(String[] args) {
        RedBlackBst<Integer, Integer> redBlackBst = new RedBlackBst<>();
        redBlackBst.put(12, 1);
        redBlackBst.put(1, 1);
        redBlackBst.put(9, 1);
        redBlackBst.put(2, 1);
        redBlackBst.put(0, 1);
        redBlackBst.put(11, 1);
        redBlackBst.put(7, 1);
        redBlackBst.put(19, 1);
        redBlackBst.put(4, 1);
        redBlackBst.put(15, 1);
        redBlackBst.put(18, 1);
        redBlackBst.put(5, 1);
        redBlackBst.put(14, 1);
        redBlackBst.put(13, 1);
        redBlackBst.put(10, 1);
        redBlackBst.put(16, 1);
        redBlackBst.put(6, 1);
        redBlackBst.put(3, 1);
        redBlackBst.put(8, 1);
        redBlackBst.put(17, 1);
        redBlackBst.check();
        redBlackBst.print();
    }

}
