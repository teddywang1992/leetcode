package facebook1;

import tree.TreeNode;

public class InorderSuccessorinBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        TreeNode pre = null;
        while (root != null) {
            if (root.val > p.val) {
                pre = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return pre;
    }
}
