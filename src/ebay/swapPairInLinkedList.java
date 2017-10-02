package ebay;
/*
        swap pairs in linked list
        follow up:use recursive
 */

import linkedList.ListNode;
import linkedList.constantList;

public class swapPairInLinkedList {
    public static void main(String[] args) {
        ListNode head = constantList.returnNormalHead();
        ListNode result = swapPairs(head);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    private static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;

        while (pre.next != null && pre.next.next != null) {
            ListNode cur = pre.next.next;
            pre.next.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            pre = cur.next;
        }

        return dummy.next;
    }
}
