package revisionback.binaryorder;

public class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }

    void preOrder() {
        System.out.println(this.val + " ");
        if (this.left == null) return;
        this.left.preOrder();
        if (this.right == null) return;
        this.right.preOrder();
    }
}

