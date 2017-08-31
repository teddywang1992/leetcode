package linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class mergeKSortedLists {
    private static Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            return left.val - right.val;
        }
    };
    public static void main(String[] args) {
        ListNode head1 = constantList.returnNormalHead();
        ListNode head2 = constantList.returnNormalHead2();
        ListNode[] lists = {head1, head2};
        ListNode result = mergeKLists(lists);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
    private static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, ListNodeComparator);
        for(int i = 0; i < lists.length; i++) {
            heap.add(lists[i]);
        }

        ListNode dummy = new ListNode(0);
        ListNode node = dummy;
        while(!heap.isEmpty()) {
            ListNode temp = heap.poll();
            node.next = temp;
            node = node.next;
            if(temp.next != null) {
                heap.add(node.next);
            }
        }
        return dummy.next;
    }

}
