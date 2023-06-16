package binarytree;

import java.util.*;

public class Insertion {
    public static void main(String[] args) {
        Node root = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);
        Node node4 = new Node(5);
        Node node5 = new Node(6);
        Node node6 = new Node(7);
        Node node7 = new Node(8);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = node7;
//        System.out.println(inorderTraversal(root, new ArrayList<>()));
//        inorderTraversalIterativeApproach(root);
//        levelOrderTraversal(root);
        preOrderTraversal(root);
    }
    public static void inorderTraversal(Node root) {
        if (root == null)
            return;
        inorderTraversal(root.left);
        System.out.println(root.data + " ");
        inorderTraversal(root.right);
    }
    public static void inorderTraversalIterativeApproach(Node root) {
        Stack<Node> stack = new Stack<>();
        if (root == null)
            return;

        Node curr = root;
        
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            System.out.println(curr.data + " ");
            curr = curr.right;
        }
    }
    public static void levelOrderTraversal(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root == null)
            return;
        queue.add(root);
        while (!queue.isEmpty()) {
            Node top = queue.peek();
            if (top.left != null) {
                queue.add(top.left);
            }
            if (top.right != null) {
                queue.add(top.right);
            }
            System.out.println(queue.poll().data + " ");
        }
    }
    public static void preOrderTraversal(Node root) {
        if (root == null)
            return;
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
}
