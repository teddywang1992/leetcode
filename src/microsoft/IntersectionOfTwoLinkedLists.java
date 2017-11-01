package microsoft;

import linkedList.ListNode;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        ListNode result = null;

        while (lengthA > lengthB) {
            headA = headA.next;
            lengthA--;
        }

        while (lengthA < lengthB) {
            headB = headB.next;
            lengthB--;
        }

        while (headA != null && headB != null) {
            if (headA.equals(headB)) {
                result = headA;
                return result;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return result;
    }

    private int getLength(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }

        return count;
    }
}
