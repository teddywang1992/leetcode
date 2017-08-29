package linkedList;

public class partitionList {
    public static void main(String[] args) {
        partitionList obj = new partitionList();
        ListNode head = constantList.returnNormalHead();
        ListNode after = obj.partition(head, 3);
        while(after != null) {
            System.out.println(after.val);
            after = after.next;
        }
    }
    private ListNode partition(ListNode head, int x) {
        if(head == null) {
            return null;
        }

        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode leftHead = leftDummy;
        ListNode rightHead = rightDummy;

        while(head != null) {
            if(head.val < x) {
                leftHead.next = head;
                leftHead = leftHead.next;
                head = head.next;
            } else if(head.val >= x) {
                rightHead.next = head;
                rightHead = rightHead.next;
                head = head.next;
            }
        }
        leftHead.next = rightDummy.next;
        rightHead.next = null;

        return leftDummy.next;
    }
}
