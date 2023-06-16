package revision.binarytree.easy;

import revision.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConstructTree {
    public static class Pair {
        TreeNode node;
        int state;

        Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{50, 25, 12 , null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Stack<Pair> stack = new Stack<>();

        TreeNode root = new TreeNode(arr[0]);
        Pair pair = new Pair(root, 1);
        stack.push(pair);

        int idx = 1;
        while (!stack.isEmpty() && idx < arr.length) {
            Pair pair1 = stack.peek();
            if (pair1.state == 1) {
                if (arr[idx] != null) {
                    TreeNode node = new TreeNode(arr[idx]);
                    pair1.node.left = node;
                    stack.push(new Pair(node, 1));
                }
                pair1.state = 2;
                idx++;
            } else if (pair1.state == 2) {
                if (arr[idx] != null) {
                    TreeNode node = new TreeNode(arr[idx]);
                    pair1.node.right = node;
                    stack.push(new Pair(node, 1));
                }
                pair1.state = 3;
                idx++;
            } else {
                stack.pop();
            }
        }
        displayTree(root);
        traversal(root);
    }

    public static void displayTree(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null) {
            System.out.print(".");
        } else {
            System.out.print(root.left.val);
        }
        System.out.print(" -> " + root.val + " -> ");
        if (root.right == null) {
            System.out.println(".");
        } else {
            System.out.println(root.right.val);
        }
        displayTree(root.left);
        displayTree(root.right);
    }

    public static void traversal(TreeNode root) {
        Pair pair = new Pair(root, 1);
        Stack<Pair> stack = new Stack<>();
        stack.push(pair);
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();

        while (!stack.isEmpty()) {
            Pair peek = stack.peek();
            if (peek.state == 1) {
                preorder.add(peek.node.val);
                peek.state = 2;
                if (peek.node.left != null) {
                    stack.push(new Pair(peek.node.left, 1));
                }

            } else if (peek.state == 2) {
                inorder.add(peek.node.val);
                peek.state = 3;
                if (peek.node.right != null) {
                    stack.push(new Pair(peek.node.right, 1));
                }
            } else {
                postorder.add(peek.node.val);
                stack.pop();
            }
        }
        System.out.println("Preorder: " + preorder);
        System.out.println("Inorder: " + inorder);
        System.out.println("Postorder: " + postorder);
    }
}
