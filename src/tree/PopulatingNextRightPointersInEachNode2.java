package tree;

/*
首先定义了一个leftMost的变量，用来指向每一层最左边的一个节点，由于左子结点可能缺失，所以这个最左边的节点有可能是上一层某个节点的右子结点，
我们每往下推一层时，还要有个指针指向上一层的父节点，因为由于右子节点的可能缺失，所以上一层的父节点必须向右移，直到移到有子节点的父节点为止，
然后把next指针连上，然后当前层的指针cur继续向右偏移，直到连完当前层所有的子节点，再向下一层推进，以此类推可以连上所有的next指针
*/

public class PopulatingNextRightPointersInEachNode2 {
    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode left = new TreeLinkNode(2);
        TreeLinkNode right = new TreeLinkNode(3);
        root.left = left;
        root.right = right;
        left.left = null;
        left.right = null;
        right.left = null;
        right.right = null;

        connect2(root);
    }
    private static void connect2(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode leftMost = root;
        while (leftMost != null) {
            TreeLinkNode p = leftMost;
            while (p != null && p.left == null && p.right == null) p = p.next;

            if (p == null) return;

            leftMost = (p.left != null) ? p.left : p.right;
            TreeLinkNode current = leftMost;

            while (p != null) {
                if (p.left != null) {
                    if (p.right != null) {
                        current.next = p.right;
                    }
                    p = p.next;
                } else if (p.right != null) {
                    p = p.next;
                } else if (p.left != null && p.right != null) {
                    p = p.next;
                } else {
                    current.next = (p.left != null) ? p.left : p.right;
                    current = current.next;
                }
            }
        }
    }

    private static void connect1(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode current = root.next;
        while (current != null) {
            if (current.left != null) {
                current = current.left;
                break;
            }

            if (current.right != null) {
                current = current.right;
                break;
            }
            current = current.next;
        }

        if (root.left != null) {
            if (root.right == null) {
                root.left.next = current;
            } else {
                root.left.next = root.right;
            }
        }

        if (root.right != null) {
            root.right.next = current;
        }

        connect1(root.left);
        connect1(root.right);
    }
}
