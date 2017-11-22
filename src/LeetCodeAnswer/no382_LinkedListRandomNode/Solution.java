package LeetCodeAnswer.no382_LinkedListRandomNode;

import java.util.Random;

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

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode head;
    Random rand = new Random();
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int val = head.val;
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            if (rand.nextInt(++count) == 0) val = cur.val;
            cur = cur.next;
        }
        return val;
    }
}
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
