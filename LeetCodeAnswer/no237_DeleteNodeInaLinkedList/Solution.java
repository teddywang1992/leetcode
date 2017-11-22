package no237_DeleteNodeInaLinkedList;

class ListNode {
	int val;
	ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
}
public class Solution {
    public void deleteNode(ListNode node) {
        if (node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
