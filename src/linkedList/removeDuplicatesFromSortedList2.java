package linkedList;

public class removeDuplicatesFromSortedList2 {
    public static void main(String[] args) {
        removeDuplicatesFromSortedList2 obj = new removeDuplicatesFromSortedList2();
        ListNode head = constantList.returnNormalHead();
        ListNode afterHead = obj.deleteDuplicates2(head);
        while(afterHead != null) {
            System.out.println(afterHead.val);
            afterHead = afterHead.next;
        }
    }
    private ListNode deleteDuplicates2(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while(head.next != null && head.next.next != null) {
            if(head.next.val == head.next.next.val) {
                int val = head.next.val;
                while(head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
}
