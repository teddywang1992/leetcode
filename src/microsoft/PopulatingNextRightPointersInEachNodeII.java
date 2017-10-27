package microsoft;

public class PopulatingNextRightPointersInEachNodeII {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode leftMost = root;
        TreeLinkNode pre = null;

        while (leftMost != null) {
            pre = leftMost;
            while (pre != null && pre.left == null && pre.right == null) pre = pre.next;
            if (pre == null) return;
            leftMost = pre.left != null ? pre.left : pre.right;
            TreeLinkNode cur = leftMost;
            while (pre != null) {
                if (cur == pre.left) {
                    if (pre.right != null) {
                        cur.next = pre.right;
                        cur = cur.next;
                    }

                    pre = pre.next;
                } else if (cur == pre.right) {
                    pre = pre.next;
                } else if (pre.left == null && pre.right == null) {
                    pre = pre.next;
                } else {
                    cur.next = pre.left != null ? pre.left : pre.right;
                    cur = cur.next;
                }
            }
        }
    }
}
