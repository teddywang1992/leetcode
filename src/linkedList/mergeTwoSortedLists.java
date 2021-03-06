package linkedList;

public class mergeTwoSortedLists {
    public static void main(String[] args) {
        ListNode head1 = constantList.returnNormalHead();
        ListNode head2 = constantList.returnNormalHead2();
        ListNode result = mergeTwoLists(head1, head2);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
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
