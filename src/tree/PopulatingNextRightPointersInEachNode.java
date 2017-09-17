package tree;

// two pointer point current is used to traversal the whole level

public class PopulatingNextRightPointersInEachNode {

    public void connectTwoPointer(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        TreeLinkNode start = root;
        TreeLinkNode current = null;
        while (start.left != null) {
            current = start;
            while(current != null) {
                current.left.next = current.right;
                if (current.next == null) {
                    current.right.next = null;
                }

                if (current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            start = start.left;
        }
    }


    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            root.left.next = root.right;
        }

        if (root.right != null) {
            if (root.next == null) {
                root.right.next = null;
            } else {
                root.right.next = root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}
