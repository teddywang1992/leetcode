package microsoft;

import linkedList.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        while (pre.next != null && pre.next.next != null) {
            ListNode cur = pre.next.next;
            pre.next.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            pre = pre.next.next;
        }

        return dummy.next;
    }
}
