package LeetCodeAnswer.Amazon;

import java.util.Stack;
// 给你一个str,里面只有 '('和‘)’,让你数valid pairs一共有多少,
//如果不是valid就返回-1. (判断是不是valid的parenthesis string，
//不是的话返回-1，是的话返回valid pair个数，即String.length() / 2 )

public class ValidParenthesis {
	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == ')') {
				if (!stack.empty() && stack.peek() == '(')
					stack.pop();
				else
					return false;
			} else if (c == ']') {
				if (!stack.empty() && stack.peek() == '[')
					stack.pop();
				else
					return false;
			} else if (c == '}') {
				if (!stack.empty() && stack.peek() == '{')
					stack.pop();
				else
					return false;
			} else
				stack.push(c);
		}
		return stack.empty();
	}
}