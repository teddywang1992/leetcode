package microsoft;

import tree.TreeNode;

public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int h = height(root);
        if (h < 0) return 0;
        return (h - 1 == height(root.right)) ? (1 << h) + countNodes(root.right) : (1 << h - 1) + countNodes(root.left);
    }

    private int height(TreeNode root) {
        if (root == null) return -1;
        return 1 + height(root.left);
    }
}
