package revisionback.binaryorder;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(4);

        root.left = node1;
        root.right = node4;
        node1.left = node2;
        node1.right = node3;
        node4.left = node6;
        node4.right = node5;
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return true;
        return preorder(root.left, root.right);
    }

    public static boolean preorder(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) return node1 == node2;
        if (node1.val != node2.val) return false;
        return node1.val == node2.val && preorder(node1.left, node2.right)
                && preorder(node1.right, node2.left);
    }
}
