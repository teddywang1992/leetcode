package FacebookInterview;

import java.util.Stack;

public class BasicCalculatorII {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int result = 0;
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if (c == '+') {
                num *= sign;
                result += num;
                sign = 1;
                num = 0;
            }
            if (c == '-') {
                num *= sign;
                sign = -1;
                result += num;
                num = 0;
            }
            if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
            }
            if (c == ')') {
                num *= sign;
                result += num;
                result *= stack.pop();
                result += stack.pop();
                num = 0;
            }
        }
        if (num != 0) {
            num *= sign;
            result += num;
        }
        return result;
    }
}
