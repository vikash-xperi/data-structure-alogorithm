package revision.binarytree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class PseudoPalindromicPaths {
    private static int ans = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(1);

        root.left = node1;
        root.right = node4;
        node1.left = node2;
        node1.right = node3;
        node4.right = node5;

        traverse(root, new Stack<>());
        System.out.println(ans);
    }

    static int count = 0;
    private static void traverse(TreeNode root, Stack<Integer> stack) {
        if (root == null) return;
        count++;
        stack.push(root.val);

        if (root.left == null && root.right == null) {
            ans += checkPalindrome(stack);
        }
        traverse(root.left, stack);
        traverse(root.right, stack);
        stack.pop();
        count -= 1;
    }

    private static int checkPalindrome(Stack<Integer> stack) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : stack) {
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        int oddCount = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (count % 2 == 0) {
                if (entry.getValue() % 2 != 0) return 0;
            } else {
                if (entry.getValue() % 2 != 0) oddCount++;
            }
        }
        if (count % 2 != 0 && oddCount > 1) return 0;
        return 1;
    }
}
