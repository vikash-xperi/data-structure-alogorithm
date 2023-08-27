package blind.leetcode;

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
class Pair {
    TreeNode node;
    int idx;
    Pair(int val) {
        this.node = new TreeNode(val);
        this.idx = 0;
    }
}

public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(10);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node3.right = node7;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        System.out.println(serialize(root));
        System.out.println(deserialize("1,2,4,N,10,N,N,5,N,N,3,6,N,N,7,N,N"));
    }

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        solve(root, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static void solve(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N,");
            return;
        }
        sb.append(root.val).append(",");
        solve(root.left, sb);
        solve(root.right, sb);
    }

    public static TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] vals = data.split(",");
        if (vals[0].equals("N")) return null;
        int rootVal = Integer.parseInt(vals[0]);
        Pair rootPair = new Pair(rootVal);
        TreeNode root = rootPair.node;
        Stack<Pair> stack = new Stack<>();
        stack.push(rootPair);
        for (int i = 1; i < data.length() && !stack.isEmpty(); i++) {
            Pair peek = stack.peek();
            if (vals[i].equals("N")) {
                peek.idx += 1;
                if (peek.idx == 2) {
                    stack.pop();
                }
                continue;
            }
            peek.idx += 1;
            Pair pair = new Pair(Integer.parseInt(vals[i]));
            if (peek.idx == 1) {
                peek.node.left = pair.node;
            } else {
                peek.node.right = pair.node;
                stack.pop();
            }
            stack.push(pair);
        }
        return root;
    }
}
