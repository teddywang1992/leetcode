package ebay;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class PathSum3 {
    private int count = 0;

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Map<Integer, Integer> preFix = new HashMap<>();
        preFix.put(0, 1);

        helper(root, 0, sum, preFix);

        return count;
    }

    private void helper(TreeNode root, int curSum, int target, Map<Integer, Integer> preFix) {
        if (root == null) return;

        curSum += root.val;

        if (preFix.containsKey(target - curSum)) {
            count += preFix.get(target - curSum);
        }

        if (!preFix.containsKey(curSum)) {
            preFix.put(curSum, 1);
        } else {
            preFix.put(curSum, preFix.get(curSum) + 1);
        }

        helper(root.left, curSum, target, preFix);
        helper(root.right, curSum, target, preFix);

        preFix.put(curSum, preFix.get(curSum) - 1);
    }
}
