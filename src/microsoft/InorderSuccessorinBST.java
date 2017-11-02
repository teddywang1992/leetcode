package microsoft;

import tree.TreeNode;

public class InorderSuccessorinBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || p == null) return null;

        TreeNode suc = null;
        while (root != null) {
            if (p.val < root.val) {
                suc = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return suc;
    }
}
