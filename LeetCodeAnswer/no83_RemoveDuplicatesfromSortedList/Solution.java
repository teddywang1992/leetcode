package no83_RemoveDuplicatesfromSortedList;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode prev = dummy, current = head;
        while (current != null) {
            if (current.val != prev.val) {
                prev = current;
                current = current.next;
            } else {
                prev.next = current.next;
                current = prev.next;
            }
        }
        
        return dummy.next;
    }
}