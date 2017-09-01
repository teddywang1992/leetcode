package linkedList;

import tree.TreeNode;

public class convertSortedListToBinarySearchTree {
    private ListNode current;
    public static void main(String[] args) {
        convertSortedListToBinarySearchTree obj = new convertSortedListToBinarySearchTree();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        node1.next = node2;
        node2.next = null;
        obj.sortedListToBST(node1);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) {
            return null;
        }
        int size = getListLength(head);
        current = head;

        return sortedListToBSTHelper(size);
    }

    private TreeNode sortedListToBSTHelper(int size) {
        if(size <= 0) {
            return null;
        }

        TreeNode left = sortedListToBSTHelper(size / 2);
        TreeNode root = new TreeNode(current.val);
        current = current.next;
        TreeNode right = sortedListToBSTHelper(size - 1 - size / 2);

        root.left = left;
        root.right = right;

        return root;
    }

    private int getListLength(ListNode head) {
        int length = 0;

        while(head != null) {
            length++;
            head = head.next;
        }

        return length;
    }
}
