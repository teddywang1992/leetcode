package microsoft;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(' || chars[i] == '{' || chars[i] == '[') {
                stack.push(chars[i]);
            } else if (!stack.isEmpty() && ((chars[i] == ')' && stack.peek() == '(') ||
                    (chars[i] == '}' && stack.peek() == '{') ||
                    (chars[i] == ']' && stack.peek() == '['))) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.size() == 0;
    }
}
