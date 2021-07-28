package Tree;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node(int val) {
        this.val = val;
        this.left = this.right = this.next = null;
    }
}
public class LeetCode116 {


    public Node connect(Node root) {
        helper(root);
        return root;
    }

    private void helper(Node node) {
        if (node == null) return;
        if (node.left != null) {
            node.left.next = node.right;
        }
        if (node.next != null && node.right != null) {
            node.right.next = node.next.left;
        }
        helper(node.left);
        helper(node.right);
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        Node t1 = new Node(9);
        Node t2 = new Node(8);
        Node t3 = new Node(4);
        Node t4 = new Node(5);
        Node t5 = new Node(1);
        Node t6 = new Node(7);
        Node t7 = new Node(2);
        Node t8 = new Node(10);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t4;
        t2.left = t5;
        t2.right = t6;
        t3.left = t7;
        t3.right = t8;
        LeetCode116 solution = new LeetCode116();
        solution.connect(root);
        Node cur = root;
        while (cur != null) {
            Node trasversCur = cur;
            while (trasversCur != null) {
                System.out.print(trasversCur.val + "->");
                trasversCur = trasversCur.next;
            }
            System.out.println("null");
            cur = cur.left;
        }
    }
}
