package linkedList;

public class linkedListCycle {
    public static void main(String[] args) {
        ListNode head = constantList.reuturnCycleHead();
        System.out.println(hasCycle(head));
    }
    private static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(slow != fast) {
            if(fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
