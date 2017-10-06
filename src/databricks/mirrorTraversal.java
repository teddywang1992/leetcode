package databricks;

import tree.TreeNode;
import tree.constantTree;

public class mirrorTraversal {
    public static void main(String[] args) {
        TreeNode root = constantTree.returnRoot();
        traversal(root);
    }

    private static void traversal(TreeNode root) {
        TreeNode cur = root;
        TreeNode prev = null;
        while (cur != null) {
            if (cur.left == null) {
                System.out.println(cur.val);
                cur = cur.right;
            } else {
                prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    System.out.println(cur.val);
                    cur = cur.right;
                }
            }
        }
    }
}
