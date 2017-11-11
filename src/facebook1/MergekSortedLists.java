package facebook1;

import linkedList.ListNode;

import java.util.PriorityQueue;

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return splitMerge(lists, 0, lists.length - 1);
    }

    private ListNode splitMerge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = left + (right - left) / 2;
        ListNode node1 = splitMerge(lists, left, mid);
        ListNode node2 = splitMerge(lists, mid + 1, right);
        return merge(node1, node2);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                node.next = node1;
                node1 = node1.next;
            }
            else {
                node.next = node2;
                node2 = node2.next;
            }
            node = node.next;
        }

        node.next = node1 == null ? node2 : node1;
        return dummy.next;
    }
    public ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((l1, l2) -> (l2.val - l1.val));
        for (ListNode list : lists) {
            while (list != null) {
                heap.offer(list);
                list = list.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            cur.next = temp.next;
            temp.next = cur;
        }
        return temp.next;
    }
}
