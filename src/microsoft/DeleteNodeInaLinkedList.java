package microsoft;

import linkedList.ListNode;

public class DeleteNodeInaLinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
