package linkedList;

public class reverseLinkedList {
    public static void main(String[] args) {
        reverseLinkedList obj = new reverseLinkedList();
        ListNode head = constantList.returnNormalHead();
        ListNode afterHead = obj.reverseList(head);
        while(afterHead != null) {
            System.out.println(afterHead.val);
            afterHead = afterHead.next;
        }
    }
    private ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode prev = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}
