package no206_ReverseLinkedList;

class ListNode {
	int val;
	ListNode next;
	public ListNode(int val) {
		this.val = val;
	}
}

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}