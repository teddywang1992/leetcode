package facebook3;

import tree.TreeNode;

public class FlattenBinaryTreeToLinkedList {
    TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }


    //1. 左边最后节点接到右边第一个节点前面 2. 讲根的有节点替换为左节点 3. 根节点递归到他的右子节点
    public void flatten1(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
}
