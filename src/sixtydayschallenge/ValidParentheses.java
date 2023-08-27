package sixtydayschallenge;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        System.out.println(validParentheses("({[()([]{})]})"));
    }

    private static boolean validParentheses(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else if (ch == ')' && !stack.isEmpty()) {
                char tmp = stack.pop();
                if (tmp != '(') return false;
            }

            else if (ch == '}' && !stack.isEmpty()) {
                char tmp = stack.pop();
                if (tmp != '{') return false;
            }

            else if (ch == ']' && !stack.isEmpty()) {
                char tmp = stack.pop();
                if (tmp != '[') return false;
            }
        }
        return stack.isEmpty();
    }
}
