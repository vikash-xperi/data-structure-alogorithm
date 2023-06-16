package revision.binarytree.medium;

import revision.binarytree.TreeNode;

import java.util.*;

public class VerticalOrderTraversal {
    static class Pair {
        int hd;
        TreeNode node;

        Pair(int hd, TreeNode node) {
            this.hd = hd;
            this.node = node;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode node1 = new TreeNode(60);
        TreeNode node2 = new TreeNode(50);
        TreeNode node3 = new TreeNode(70);
        TreeNode node4 = new TreeNode(20);
        TreeNode node5 = new TreeNode(30);
        TreeNode node6 = new TreeNode(80);
        TreeNode node7 = new TreeNode(40);

        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;
        node4.right = node6;
        node5.right = node7;
        System.out.print(verticalOrderTraversal(root));
    }

    private static List<Integer> verticalOrderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new ArrayDeque<>();

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
                queue.add(new Pair(curr.hd - 1, curr.node.left));
            }

            if (curr.node.right != null) {
                queue.add(new Pair(curr.hd + 1, curr.node.right));
            }
        }

        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            res.addAll(entry.getValue());
        }
        return res;
    }
}
