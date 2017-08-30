package linkedList;

public class sortList {
    public static void main(String[] args) {
        ListNode head = constantList.returnRandomHead();
        ListNode result = sortList(head);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    private static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode middle = findMiddle(head);

        ListNode right = sortList(middle.next);
        middle.next = null;//用来把链表后半部分删除掉
        ListNode left = sortList(head);

        return merge(left, right);

    }

    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                head.next = l1;
                head = head.next;
                l1 = l1.next;
            } else {
                head.next = l2;
                head = head.next;
                l2 = l2.next;
            }
        }
        if(l1 != null) {
            head.next = l1;
        } else {
            head.next = l2;
        }
        return dummy.next;
    }
}
