package ebay;

import tree.TreeNode;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        helper(root);

        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        if (root.left != null && root.right != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        } else if (root.left != null) {
            root.right = root.left;
            root.left = null;
        } else {
            root.left = root.right;
            root.right = null;
        }
        helper(root.left);
        helper(root.right);
    }
}
