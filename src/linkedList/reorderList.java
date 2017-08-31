package linkedList;

public class reorderList {
    public static void main(String[] args) {
        ListNode head = constantList.returnRandomHead();
        reorderList(head);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
    private static void reorderList(ListNode head) {
        if(head == null) {
            return;
        }
        ListNode middle = findMiddle(head);
        ListNode tail = reverseList(middle.next);
        middle.next = null;

        merge(head, tail);
    }

    private static void merge(ListNode head, ListNode tail) {
        int index = 0;
        ListNode dummy = new ListNode(0);
        while(head != null && tail != null) {
            if(index % 2 == 0) {
                dummy.next = head;
                head = head.next;
            } else {
                dummy.next = tail;
                tail = tail.next;
            }
            index++;
            dummy = dummy.next;
        }
        if(head != null) {
            dummy.next = head;
        } else if (tail != null) {
            dummy.next = tail;
        }
    }

    private static ListNode findMiddle(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverseList(ListNode head) {
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
