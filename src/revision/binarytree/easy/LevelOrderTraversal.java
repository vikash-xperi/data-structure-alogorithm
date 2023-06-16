package revision.binarytree.easy;

import revision.binarytree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        levelOrderTraversal(root);
    }

    private static void levelOrderTraversal(TreeNode root) {
        if (root == null)
            return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if (tmp == null) {
                return;
            }
            System.out.println(tmp.val);
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
    }
}
