package facebook3;

import linkedList.ListNode;

public class ReorderList {
    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(3);
        ListNode p4 = new ListNode(4);
        ListNode p5 = new ListNode(5);
        ListNode p6 = new ListNode(6);
        ListNode p7 = new ListNode(7);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p5;
        p5.next = p6;
        p6.next = p7;

//        System.out.println(middle.val);
    }

    public void reorderList(ListNode head) {
        if (head == null) return;
        ListNode middle = findMiddle(head);
        ListNode node = reverse(middle.next);
        middle.next = node;
        merge(head, middle);
    }

    private void merge(ListNode head, ListNode middle) {
        ListNode cur = middle.next;
        while(head != middle){
            middle.next = cur.next;
            cur.next = head.next;
            head.next = cur;
            head = cur.next;
            cur = middle.next;
        }
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
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
