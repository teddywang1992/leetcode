package facebook;

import linkedList.ListNode;

public class ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = 0;
        for (ListNode temp = head; temp != null; temp = temp.next, length++);

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode anchor = dummy;

        for (int i = 0; i < length / k; i++) {
            ListNode cur = anchor.next;
            for (int j = 1; j < k; j++) {
                ListNode post = cur.next;
                cur.next = post.next;
                post.next = anchor.next;
                anchor.next = post;
            }
            anchor = cur;
        }

        return dummy.next;
    }
}
