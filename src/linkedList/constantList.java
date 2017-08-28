package linkedList;

public class constantList {
    private static ListNode head = new ListNode(1);
    private static ListNode node2 = new ListNode(1);
    private static ListNode node3 = new ListNode(2);
    private static ListNode node4 = new ListNode(3);
    private static ListNode node5 = new ListNode(3);

    public static ListNode returnNormalHead() {
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        return head;
    }
}
