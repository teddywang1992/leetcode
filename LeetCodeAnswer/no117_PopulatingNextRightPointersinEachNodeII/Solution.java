package no117_PopulatingNextRightPointersinEachNodeII;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	public TreeLinkNode(int x) {
		// TODO Auto-generated constructor stub
		val = x;
	}
}
public class Solution {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode temp = new TreeLinkNode(0);
            TreeLinkNode cur = temp;
            while (root != null) {
                if (root.left != null) {
                    cur.next = root.left;
                    cur = cur.next;
                }
                if (root.right != null) {
                    cur.next = root.right;
                    cur = cur.next;
                }
                root = root.next;
            }
            root = temp.next;
        }
    }
}