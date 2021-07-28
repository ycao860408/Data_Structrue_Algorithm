package Tree.AVL;

public class AVLNode {
    public int val, height;
    public AVLNode left, right;

    public AVLNode(int val) {
        this.val = val;
        this.height = 1;
        this.left = this.right = null;
    }
}
