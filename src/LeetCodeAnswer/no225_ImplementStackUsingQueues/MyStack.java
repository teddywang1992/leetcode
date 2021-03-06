package LeetCodeAnswer.no225_ImplementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

	private Queue<Integer> queue = new LinkedList<Integer>();

	public void push(int x) {
		queue.add(x);
		for (int i = 1; i < queue.size(); i++)
			queue.add(queue.remove());
	}

	public void pop() {
		queue.remove();
	}

	public int top() {
		return queue.peek();
	}

	public boolean empty() {
		return queue.isEmpty();
	}
}