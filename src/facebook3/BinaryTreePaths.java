package facebook3;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, result, String.valueOf(root.val));
        return result;
    }

    private void dfs(TreeNode root, List<String> result, String path) {
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }

        if (root.left != null) {
            dfs(root.left, result, path + "->" + root.left.val);
        }

        if (root.right != null) {
            dfs(root.right, result, path + "->" + root.right.val);
        }
    }
}
