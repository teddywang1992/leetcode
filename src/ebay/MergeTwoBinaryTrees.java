package ebay;

import tree.TreeNode;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;
        else if (t1 == null) return t2;
        else if (t2 == null) return t1;
        else t1.val += t2.val;

        helper(t1, t2);
        return t1;
    }

    private void helper(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return;
        else if (t1 == null) t1 = t2;
        else if (t2 == null) return;

        if (t1.left != null && t2.left != null) t1.left.val += t2.left.val;
        if (t1.right != null && t2.right != null) t1.right.val += t2.right.val;
        if (t1.left == null && t2.left != null) t1.left = new TreeNode(t2.left.val);
        if (t1.right == null && t2.right != null) t1.right = new TreeNode(t2.right.val);
        helper(t1.left, t2.left);
        helper(t1.right, t2.right);
    }
}
