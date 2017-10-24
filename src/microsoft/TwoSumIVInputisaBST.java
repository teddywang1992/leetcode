package microsoft;

import tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class TwoSumIVInputisaBST {
    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper(root, set, k);
    }

    private boolean helper(TreeNode root, Set<Integer> set, int k) {
        if (root == null) return false;

        if (set.contains(k - root.val)) return true;
        set.add(root.val);

        return helper(root.left, set, k) || helper(root.right, set, k);
    }
}
