package linkedList;

public class removeNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode node = constantList.returnRandomHead();
        ListNode result = removeNthFromEnd(node, 3);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;

        for(int i = 0; i < n; i++) {
            if(fast != null) {
                fast = fast.next;
            }
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;

        return dummy.next;
    }
}
