package FacebookInterview;

import java.util.Stack;

public class BasicCalculator {
    public static void main(String[] args) {
        String s = "3+2*2";
        System.out.println(calculate(s));
    }

    public static int calculate(String s) {
        int num = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + Character.getNumericValue(c);
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (sign == '+') stack.push(num);
                if (sign == '-') stack.push(-num);
                if (sign == '*') stack.push(stack.pop() * num);
                if (sign == '/') stack.push(stack.pop() / num);
                sign = c;
                num = 0;
            }

        }
        int sum = 0;
        for (int i : stack) {
            sum += i;
        }
        return sum;
    }
}
