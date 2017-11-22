package no150_EvaluateReversePolishNotation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
//        if (tokens == null || tokens.length == 0) return 0;
//        int len = tokens.length;
//        int[] result = new int[len];
//        int pointer = 0;
//        for (int i = 0; i < len; i ++) {
//            String curr = tokens[i];
//            if (Character.isDigit(curr.charAt(curr.length() - 1))) {
//                result[pointer ++] = Integer.parseInt(curr);
//            } else {
//                if (curr.equals("+")) {
//                    result[pointer - 2] += result[--pointer];
//                } else if (curr.equals("-")) {
//                    result[pointer - 2] -= result[--pointer];
//                } else if (curr.equals("*")) {
//                    result[pointer - 2] *= result[--pointer];
//                } else {
//                    result[pointer - 2] /= result[--pointer];
//                }
//            }
//        }
//        return result[0];
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                int a = stack.pop();
                int b = stack.pop();
                res = a + b;
                stack.push(res);
            } else if (tokens[i].equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                res = b - a;
                stack.push(res);
            } else if (tokens[i].equals("*")) {
                int a = stack.pop();
                int b = stack.pop();
                res = a * b;
                stack.push(res);
            } else if (tokens[i].equals("/")) {
                int a = stack.pop();
                int b = stack.pop();
                res = b / a;
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        res = stack.pop();
        return res;
    }
}
