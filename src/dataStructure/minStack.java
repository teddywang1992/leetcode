package dataStructure;

import java.util.Stack;

public class minStack {
    public static void main(String[ ] args) {
        MinStack1 minStack1 = new MinStack1();
        minStack1.push(1);
        minStack1.push(2);
        minStack1.push(0);
        System.out.println("getMin: " + minStack1.getMin());
        System.out.println("get peek: " + minStack1.top());
        minStack1.pop();
        System.out.println("getMin: " + minStack1.getMin());
        System.out.println("get peek: " + minStack1.top());
    }
}

class MinStack2 {
    Stack<Integer> stack;
    int minValue = Integer.MAX_VALUE;

    public MinStack2() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if(x <= minValue) {
            stack.push(minValue);
            minValue = x;
        }
        stack.push(x);
    }
    public void pop() {
        if(stack.pop() == minValue) {
            minValue = stack.pop();
        }
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return minValue;
    }
}

class MinStack1 {
    Stack<Integer> minStack;
    Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack1() {
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()) {
            minStack.push(x);
        } else {
            minStack.push(Math.min(minStack.peek(), x));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}


