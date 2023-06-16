package revision.binarytree.medium;

import revision.binarytree.TreeNode;

public class BurnTree {
    static class Depth {
        int d;
        Depth(int d) {
            this.d = d;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(3);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node3.left = node4;
        node3.right = node5;
        node4.left = node6;
        System.out.println(minTime(root, 2));
    }

    static int ans = -1;
    private static int minTime(TreeNode root, int target) {
        Depth depth = new Depth(-1);
        burn(root, target, depth);
        return ans;
    }

    private static int burn(TreeNode root, int target, Depth depth) {
        if (root == null) return 0;

        if (root.val == target) {
            depth.d = 1;
            return 1;
        }
        Depth ld = new Depth(-1);
        Depth rd = new Depth(-1);

        int lh = burn(root.left, target, ld);
        int rh = burn(root.right, target, rd);

        if (ld.d != -1) {
            ans = Math.max(ans, ld.d + 1 + rh);
            depth.d = ld.d + 1;
        }else if (rd.d != -1) {
            ans = Math.max(ans, rd.d + 1 + lh);
            depth.d = rd.d + 1;
        }
        return Math.max(lh, rh) + 1;
    }


}
