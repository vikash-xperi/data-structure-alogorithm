package revision.binarytree.medium;

import revision.binarytree.TreeNode;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(3);

        root.left = node1;
        root.right = node6;
        node1.left = node2;
        node2.right = node3;
        node3.left = node4;
        node3.right = node5;

        System.out.print(lca(root, 7, 3).val);
    }

    private static TreeNode lca(TreeNode root, int val1, int val2) {
        if (root == null) {
            return null;
        }
        if (root.val == val1 || root.val == val2) {
            return root;
        }
        TreeNode left = lca(root.left, val1, val2);
        TreeNode right = lca(root.right, val1, val2);

        if (left == null) return right;
        if (right == null) return left;

        return root;
    }
}
