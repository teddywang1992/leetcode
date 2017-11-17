package FacebookInterview;

import linkedList.ListNode;
import tree.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    ListNode cur = null;
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        cur = head;
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return helper(length);
    }

    private TreeNode helper(int length) {
        if (length <= 0) return null;
        TreeNode left = helper(length / 2);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = helper(length - length / 2 - 1);
        root.left = left;
        root.right = right;
        return root;
    }
}
