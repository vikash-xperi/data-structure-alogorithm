package revisionback.tree;

import java.util.Stack;

public class BasicTree {

    public static void main(String[] args) {
        TreeNode root = createTree();
        inorderRecursion(root);
        inorderIteration(root);
    }

    public static TreeNode createTree() {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(9);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.right = node7;
        node2.left = node5;
        node2.right = node6;
        node6.right = node8;
        return root;
    }

    public static void inorderRecursion(TreeNode root) {
        if (root == null) return;
        inorderRecursion(root.left);
        System.out.print(root.data +" ");
        inorderRecursion(root.right);
    }

    public static void inorderIteration(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode tmp = stack.peek();
            if (tmp.left != null) {
                stack.push(tmp.left);
                continue;
            }
            if (tmp.left == null) {
                System.out.print(tmp.data + "");
            }
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            stack.pop();
        }
    }
}
