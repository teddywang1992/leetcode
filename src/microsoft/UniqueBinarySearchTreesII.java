package microsoft;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int start, int end) {
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null);
            return list;
        }

        List<TreeNode> left;
        List<TreeNode> right;

        for (int i = start; i <= end; i++) {
            left = helper(start, i - 1);
            right = helper(i + 1, end);

            for (TreeNode lNode : left) {
                for (TreeNode rNode : right) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = lNode;
                    cur.right = rNode;
                    list.add(cur);
                }
            }
        }

        return list;
    }
}
