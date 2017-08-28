package linkedList;

public class removeDuplicatesFromSortedList {
    public static void main(String[] args) {
        removeDuplicatesFromSortedList obj = new removeDuplicatesFromSortedList();
        ListNode head = constantList.returnNormalHead();
        ListNode afterHead = obj.deleteDuplicates(head);
        while (afterHead != null) {
            System.out.println(afterHead.val);
            afterHead = afterHead.next;
        }
    }

    private ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }
}
