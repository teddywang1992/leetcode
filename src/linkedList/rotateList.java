package linkedList;

public class rotateList {
    public static void main(String[] args) {
        ListNode test = constantList.returnRandomHead();
        ListNode result = rotateRight(test, 3);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    private static ListNode rotateRight(ListNode head, int k) {
        if(head == null) {
            return null;
        }

        int length = getListLength(head);
        k = k % length;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for(int i = 0; i < k; i++) {
            if(fast != null) {
                fast = fast.next;
            }
        }

        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
    private static int getListLength(ListNode head) {
        int length = 0;

        if(head == null) {
            return length;
        }

        while(head != null) {
            length++;
            head = head.next;
        }

        return length;
    }
}
