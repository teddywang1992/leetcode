package no23_MergeKSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import helper.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, comp);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) heap.add(lists[i]);
        }
        while (!heap.isEmpty()) {
            ListNode head = heap.poll();
            tail.next = head;
            tail = head;
            if (head.next != null) heap.add(head.next);
        }
        return dummy.next;
    }
    private Comparator<ListNode> comp = new Comparator<ListNode>() {
      public int compare(ListNode left, ListNode right) {
          if (left == null) {
              return 1;
          } else if (right == null) {
              return -1;
          } else {
              return left.val - right.val;
          }
      }  
    };
}