package dataStructure;

import java.util.Stack;

public class implementQueueUsingStacks {
}
class MyQueue {
    Stack<Integer> tempStack;
    Stack<Integer> resultStack;

    public void tempStackToResultStack() {
        while(!tempStack.isEmpty()) {
            resultStack.push(tempStack.pop());
        }
    }

    /** Initialize your data structure here. */
    public MyQueue() {
        tempStack = new Stack<>();
        resultStack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        tempStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(resultStack.isEmpty()) {
            tempStackToResultStack();
        }
        return resultStack.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(resultStack.isEmpty()) {
            tempStackToResultStack();
        }
        return resultStack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(tempStack.isEmpty() && resultStack.isEmpty()) {
            return true;
        }
        return false;
    }
}
