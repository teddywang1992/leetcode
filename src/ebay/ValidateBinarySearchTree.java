package ebay;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(list, root);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) return false;
        }

        return true;
    }

    private void helper(List<Integer> list, TreeNode root) {
        if (root == null) return;

        helper(list, root.left);
        list.add(root.val);
        helper(list, root.right);
    }
}
