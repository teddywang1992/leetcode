package ebay;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSum2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return result;

        helper(result, list, root, sum);

        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> list, TreeNode root, int sum) {
        if (root == null) return;

        list.add(root.val);

        if (root.left == null && root.right == null && root.val == sum) {
            result.add(new ArrayList<>(list));
        }

        helper(result, list, root.left, sum - root.val);
        helper(result, list, root.right, sum - root.val);
        list.remove(list.size() - 1);
    }
}
