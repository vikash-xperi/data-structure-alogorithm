package revisionback.binaryorder;

public class MaxDepth {
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
        System.out.println(maxDepth(root));
    }

    private static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return height(root);
    }
    public static int height(TreeNode root) {
        if (root == null) return 0;
        int lh = 1 + height(root.left);
        int rh = 1 + height(root.right);
        return Math.max(lh, rh);
    }
}
