import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
    int data;
    List<TreeNode> child = new ArrayList<>();

    TreeNode(int data) {
        this.data = data;
    }

    TreeNode() {

    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", child=" + child +
                '}';
    }
}
public class Questions {
    public static void main(String[] args) {
        TreeNode treeNode = constructTree("1(2(5)(6))(3(7))(4(8)(9)(10))", 0);
        System.out.println(treeNode);
    }

    public static TreeNode constructTree(String input) {
        Stack<Character> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        TreeNode root = new TreeNode();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack1.push('(');
            } else if (input.charAt(i) == ')') {
                stack1.pop();
                stack2.pop();
            } else {
                StringBuilder sb = new StringBuilder();
                while (input.charAt(i) != '(' && input.charAt(i) != ')') {
                    sb.append(input.charAt(i));
                    i++;
                }
                i--;
                TreeNode node = new TreeNode(Integer.parseInt(sb.toString()));

                if (stack2.isEmpty()) {
                    root = node;
                } else {
                    stack2.peek().child.add(node);
                }
                stack2.push(node);
            }
        }
        return root;
    }

    public static TreeNode constructTree(String input, int i) {
        if (i == input.length())
            return null;

        StringBuilder sb = new StringBuilder();
        while (input.charAt(i) != '(' && input.charAt(i) != ')') {
            sb.append(input.charAt(i));
            i++;
        }
        TreeNode root = new TreeNode(Integer.parseInt(sb.toString()));

        while (i < input.length() && input.charAt(i) != ')') {
            if (input.charAt(i) == '(') {
                i++;
                root.child.add(constructTree(input, i));
            }
            if (i < input.length() && input.charAt(i) == ')')
                i++;
        }
        if (i < input.length() && input.charAt(i) == ')') i++;

        return root;
    }

}




























