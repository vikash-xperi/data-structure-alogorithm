package revision.arrays.easy;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(isValidParentheses("[{()(){{[{}]}}}"));
    }

    private static boolean isValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); ++i) {
            if (stack.isEmpty() || s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else if ((s.charAt(i) == ')' && stack.peek() == '(') ||
                    (s.charAt(i) == '}' && stack.peek() == '{') ||
                    (s.charAt(i) == ']' && stack.peek() == '[')) {
                stack.pop();
            } else {
                return false;
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
