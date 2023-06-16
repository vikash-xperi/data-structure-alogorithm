package revision.binarytree.medium;

import revision.binarytree.TreeNode;

import java.util.*;

public class Leetcode102 {
    static class Pair {
        int hd;
        TreeNode node;

        public Pair(int hd, TreeNode node) {
            this.node = node;
            this.hd = hd;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.left = node7;

        System.out.println(levelOrderTraversal(root));
    }

    private static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<Pair> queue = new ArrayDeque<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();

        queue.add(new Pair(0, root));

        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            if (map.containsKey(curr.hd)) {
                map.get(curr.hd).add(curr.node.val);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(curr.node.val);
                map.put(curr.hd, list);
            }
            if (curr.node.left != null) {
                queue.add(new Pair(curr.hd + 1, curr.node.left));
            }
            if (curr.node.right != null) {
                queue.add(new Pair(curr.hd + 1, curr.node.right));
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }
}
