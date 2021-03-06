package microsoft;

public class PopulatingNextRightPointersInEachNode {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode cur = null;

        while (root.left != null) {
            cur = root;
            while (cur != null) {
                cur.left.next = cur.right;

                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            root = root.left;
        }
    }
}
