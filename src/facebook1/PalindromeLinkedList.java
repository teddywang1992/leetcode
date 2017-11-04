package facebook1;

import linkedList.ListNode;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);

        while (head != null && middle.next != null) {
            if (head.val != middle.next.val) return false;
            head = head.next;
            middle = middle.next;
        }

        return true;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;

        while (head != null) {
            ListNode cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }

        return pre;
    }
}
