package linkedList;

public class intersectionOfTwoLinkedLists {
    public static void main(String[] args) {
        ListNode list1 = constantList.returnNormalHead();
        ListNode list2 = constantList.returnNormalHead2();
        ListNode result = getIntersectionNode(list1, list2);
        while(result != null) {
            System.out.println(result.val);
        }
    }
    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }

        int lengthA = getListLength(headA);
        int lengthB = getListLength(headB);
        while(lengthA > lengthB) {
            lengthA--;
            headA = headA.next;
        }
        while(lengthB > lengthA) {
            lengthB--;
            headB = headB.next;
        }
        while(headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    static int getListLength(ListNode head) {
        int length = 0;
        if(head == null) {
            return length;
        }
        while(head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
