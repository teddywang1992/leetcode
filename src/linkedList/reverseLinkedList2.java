package linkedList;

public class reverseLinkedList2 {
    public static void main(String[] args) {
        reverseLinkedList2 obj = new reverseLinkedList2();
    }
    private ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        //find the m node
        for(int i = 1; i < m; i++) {
            if(head == null) {
                return null;
            } else {
                head = head.next;
            }
        }

        //reverse m-n node except m node and n node
        ListNode prevmNode = head;
        ListNode mNode = head.next;
        ListNode nNode = head.next;
        ListNode postnNode = mNode.next;
        for(int i = m; i < n; i++) {
            if(postnNode == null) {
                return null;
            }
            ListNode temp = postnNode.next;
            postnNode.next = nNode;
            nNode = postnNode;
            postnNode = temp;
        }

        //connect m node and n node to their new nodes
        mNode.next = postnNode;
        prevmNode.next = nNode;

        return dummy.next;
    }
}
