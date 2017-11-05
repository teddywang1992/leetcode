package facebook1;

public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode dummy = new TreeLinkNode(-1), cur = dummy;
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
            root = dummy.next;
        }
    }
    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
}
