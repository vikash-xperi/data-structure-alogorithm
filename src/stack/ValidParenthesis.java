package stack;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(isValid("(){}[]((({{[]()}})))"));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack();

        for (int i = 0; i < s.length(); ++i) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.peek() == '(' && s.charAt(i) == ')' ||
                    stack.peek() == '{' && s.charAt(i) == '}' ||
                    stack.peek() == '[' && s.charAt(i) == ']') {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
