package microsoft;

import linkedList.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;

        ListNode pre = null;
        ListNode cur = null;

        while (head != null) {
            cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }

        return pre;
    }
}
