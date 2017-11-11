package facebook1;

import linkedList.ListNode;

public class ReverseNodesinkGroup1 {
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        for (ListNode temp = head; temp != null; temp = temp.next, length++);
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        dummy.next = head;
        for (int i = 0; i < length / k; i++) {
            ListNode cur = temp.next;
            for (int j = 1; j < k; j++) {
                ListNode post = cur.next;
                cur.next = post.next;
                post.next = temp.next;
                temp.next = post;
            }
            temp = cur;
        }

        return dummy.next;
    }
}
