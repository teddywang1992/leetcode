package FacebookInterview;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class DeepCopyTree {
    Map<TreeNode, TreeNode> map = new HashMap<>();
    public TreeNode cloneTree(TreeNode root) {
        if (root == null) return null;
        TreeNode newRoot;
        if (map.containsKey(root)) {
            newRoot = map.get(root);
        }
        else {
            newRoot = new TreeNode(root.val);
        }
        newRoot.left = cloneTree(root.left);
        newRoot.right = cloneTree(root.right);
        return newRoot;
    }
}
