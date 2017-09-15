package linkedList;

//
//注意把回转的后边链表连接上并且只比较后半边链表
public class PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        node1.next = node2;
        node2.next = node3;
        System.out.println(isPalindrome(node1));
    }

    private static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode middle = findMiddle(head);
        //System.out.println(middle.val);
        middle.next = reverse(middle.next);

        ListNode l1 = head;
        ListNode l2 = middle.next;

        while (l1 != null && l2 != null && l1.val == l2.val) {
            //System.out.println(l2.val);
            l1 = l1.next;
            l2 = l2.next;
            //System.out.println(l1.val);
        }

        return l2 == null;
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            //System.out.println(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private static ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode cur = head.next;
            head.next = pre;
            pre = head;
            head = cur;
        }

        return pre;
    }
}
