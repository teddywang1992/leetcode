package ebay;

import linkedList.ListNode;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        int power = 0;
        int curValue = 0;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;

        while (l1 != null && l2 != null) {
            curValue = (l1.val + l2.val + power) % 10;
            power = (l1.val + l2.val + power) / 10;

            ListNode cur = new ListNode(curValue);
            head.next = cur;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            curValue = (l1.val + power) % 10;
            power = (l1.val + power) / 10;

            ListNode cur = new ListNode(curValue);
            head.next = cur;
            head = head.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            curValue = (l2.val + power) % 10;
            power = (l2.val + power) / 10;

            ListNode cur = new ListNode(curValue);
            head.next = cur;
            head = head.next;
            l2 = l2.next;
        }

        if (power == 1) {
            ListNode cur = new ListNode(power);
            head.next = cur;
        }

        return dummy.next;
    }
}
