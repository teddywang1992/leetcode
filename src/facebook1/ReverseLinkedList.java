package facebook1;

import linkedList.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

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
