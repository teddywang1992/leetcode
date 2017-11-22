package no385_MiniParser;

import java.util.List;
import java.util.Stack;

class NestedInteger {
	// Constructor initializes an empty nested list.
	public NestedInteger() {
	}

	// Constructor initializes a single integer.
	public NestedInteger(int value) {
	};

	// @return true if this NestedInteger holds a single integer, rather than a
	// nested list.
	public boolean isInteger() {
		return false;
	};

	// @return the single integer that this NestedInteger holds, if it holds a
	// single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger() {
		return null;
	};

	// Set this NestedInteger to hold a single integer.
	public void setInteger(int value) {
	};

	// Set this NestedInteger to hold a nested list and adds a nested integer to
	// it.
	public void add(NestedInteger ni) {
	};

	// @return the nested list that this NestedInteger holds, if it holds a
	// nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList() {
		return null;
	};

	public class Solution {
		public NestedInteger deserialize(String s) {
			if (s.isEmpty())
				return null;
			if (s.charAt(0) != '[')
				return new NestedInteger(Integer.valueOf(s));
			Stack<NestedInteger> stack = new Stack<NestedInteger>();
			NestedInteger curr = null;
			int l = 0;
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (c == '[') {
					if (curr != null) {
						stack.push(curr);
					}
					curr = new NestedInteger();
					l = i + 1;
				} else if (c == ']') {
					String num = s.substring(l, i);
					if (!num.isEmpty()) {
						curr.add(new NestedInteger(Integer.valueOf(num)));
					}
					if (!stack.isEmpty()) {
						NestedInteger pop = stack.pop();
						pop.add(curr);
						curr = pop;
					}
					l = i + 1;
				} else if (c == ',') {
					if (s.charAt(i - 1) != ']') {
						String num = s.substring(l, i);
						curr.add(new NestedInteger(Integer.valueOf(num)));
					}
					l = i + 1;
				}
			}
			return curr;
		}
	}
}