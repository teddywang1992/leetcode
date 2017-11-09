package facebook2;

import linkedList.ListNode;

public class insertCycleLinkedList {
//    13. 第一题3sum，第二题在一个循环聊表中插入一个新节点，返回新的头节点(第二题那个循环链表是sorted的)
//    给一个头结点head,与一个要插入的节点，插入之后返回新的头结点。所以什么是头结点？应该在什么位置插入新节点？
//    根据模糊的信息，作为一个engineer，必须学会问clarify的问题，那么这里没有面试官，那我只能猜了。头结点就是value值最小的节点，
//    插入的新节点应该要找value的值的大小插入
//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=144124&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
//
//    insert node to sorted linkedList
    class InsertLinkedList {
        public ListNode insert(ListNode head, ListNode node) {
            ListNode fakeHead = new ListNode(0);
            fakeHead.next = head;
            ListNode mover = head;
            ListNode previous = fakeHead;
            while (mover != null && mover.val < node.val) {
                mover = mover.next;
                previous = previous.next;
            }
            previous.next = node;
            node.next = mover;
            return fakeHead.next;
        }
    }

    public ListNode makeList(int[] input) {
        ListNode fakeHead = new ListNode(0);
        ListNode mover = fakeHead;
        for (int num : input) {
            mover.next = new ListNode(num);
            mover = mover.next;
        }
        return fakeHead.next;
    }
}
