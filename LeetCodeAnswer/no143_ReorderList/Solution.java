package no143_ReorderList;

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
    public void reorderList(ListNode head) {
        if(head == null){
            return;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode curr = slow.next;
        slow.next = null;
        while (curr != null){
            ListNode next = curr.next;
            curr.next = slow.next;
            slow.next = curr;
            curr = next;
        }
        
        ListNode tmp = slow.next;
        while (true){
            if(head == slow){
                head.next = tmp;
                break;
            } 
            
            ListNode headNext = head.next;
            ListNode tmpNext = tmp.next;
            head.next = tmp;
            tmp.next = headNext;
            head = headNext;
            tmp = tmpNext;
             
        }
    }
}