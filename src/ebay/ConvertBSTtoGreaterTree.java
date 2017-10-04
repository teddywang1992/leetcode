package ebay;
//538. Convert BST to Greater Tree  逆中跟遍历
import tree.TreeNode;

public class ConvertBSTtoGreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root == null) return null;
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.right);
        sum += root.val;
        root.val = sum;
        helper(root.left);
    }
}
