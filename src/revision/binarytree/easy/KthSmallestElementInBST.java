package revision.binarytree.easy;

import revision.binarytree.TreeNode;

public class KthSmallestElementInBST {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        System.out.println(kthSmallest(root, 1));
    }

    private static int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            k--;
            return k;
        }
        if (k == 0) {
            return root.val;
        }
        k = kthSmallest(root.left, k);
        k = kthSmallest(root.right, k);
        return root.val;
    }
}
