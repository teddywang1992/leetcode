package ebay;

import tree.TreeNode;

public class KthSmallestElementInABST {
    private static int kthSmallest(TreeNode root, int k) {
        int count = count(root.left);

        if (k < count + 1) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k - 1 - count);
        } else {
            return root.val;
        }
    }

    private static int count(TreeNode node) {
        if (node == null) return 0;

        return 1 + count(node.left) + count(node.right);
    }
}
