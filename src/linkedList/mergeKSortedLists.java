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
        ListNode result = mergeKLists2(lists);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }
    private static ListNode mergeKLists2(ListNode[] lists) {
        if(lists.length == 0 || lists == null) {
            return null;
        }

        return mergeKListsHelper(lists, 0, lists.length - 1);
    }

    private static ListNode mergeKListsHelper(ListNode[] lists, int start, int end) {
        //递归出口
        if(start == end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;
        ListNode left = mergeKListsHelper(lists, start, mid);
        ListNode right = mergeKListsHelper(lists, mid + 1, end);

        return mergeTwoLists(left, right);
    }

    private static ListNode mergeTwoLists(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode node = dummy;

        while(left != null && right != null) {
            if(left.val < right.val) {
                node.next = left;
                node = node.next;
                left = left.next;
            } else {
                node.next = right;
                node = node.next;
                right = right.next;
            }
        }
        if(left != null) {
            node.next = left;
        } else {
            node.next = right;
        }

        return dummy.next;
    }
    private static ListNode mergeKLists1(ListNode[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        Queue<ListNode> heap = new PriorityQueue<>(lists.length, ListNodeComparator);
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
