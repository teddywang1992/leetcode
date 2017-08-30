package linkedList;

class constantList {
    private static ListNode head1 = new ListNode(1);
    private static ListNode node2 = new ListNode(1);
    private static ListNode node3 = new ListNode(2);
    private static ListNode node4 = new ListNode(3);
    private static ListNode node5 = new ListNode(4);
    private static ListNode head2 = new ListNode(0);
    private static ListNode node6 = new ListNode(3);
    private static ListNode node7 = new ListNode(4);
    private static ListNode node8 = new ListNode(7);
    private static ListNode node9 = new ListNode(9);

    static ListNode returnNormalHead() {
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        return head1;
    }
    static ListNode returnNormalHead2() {
        head2.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = null;
        return head2;
    }
    static ListNode returnRandomHead() {
        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        node9.next = null;
        return head1;

    }
}
