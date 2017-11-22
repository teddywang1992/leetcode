package LeetCodeAnswer.no232_ImplementQueueUsingStacks;

import java.util.Stack;

class MyQueue {
    // Push element x to the back of queue.
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    
    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }
    
    private void stack2ToStack1() {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }
    public void push(int x) {
        stack2.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (stack1.isEmpty()) {
            this.stack2ToStack1();
        }
        stack1.pop();
    }

    // Get the front element.
    public int peek() {
        if (stack1.isEmpty()) {
            this.stack2ToStack1();
        }
        return stack1.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        if (stack1.isEmpty()) {
            this.stack2ToStack1();
        }
        return stack1.isEmpty();
    }
}