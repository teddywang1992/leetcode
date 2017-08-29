package linkedList;

public class removeLinkedListElements {
    public static void main(String[] args) {
        removeLinkedListElements obj = new removeLinkedListElements();
        ListNode head = constantList.returnNormalHead();
        ListNode result = obj.removeElements(head, 3);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
    private ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        dummy.next = head;

        while(prev.next != null) {
            if(prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
