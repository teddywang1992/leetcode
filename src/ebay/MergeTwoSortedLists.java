package ebay;

import linkedList.ListNode;
import linkedList.constantList;

public class MergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode l1 = constantList.returnNormalHead();
        ListNode l2 = constantList.returnNormalHead2();

        ListNode result = mergeTwoLists(l1, l2);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            } else {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            }
        }

        if (l2 != null) {
            head.next = l2;
        } else {
            head.next = l1;
        }

        return dummy.next;
    }
}
