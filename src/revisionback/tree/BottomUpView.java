package revisionback.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class BottomUpView {

    private static Map<Integer, Integer> map = new TreeMap<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;

        solve(root, 0);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public static void solve(TreeNode root, int currLevel) {
        if (root == null) return;

        map.put(currLevel, root.data);

        solve(root.left, currLevel - 1);
        solve(root.right, currLevel + 1);
    }
}
