package tree;

/* there are three solution situations.
    1. not find the solution
    2. its successor
    3. in its right or right child's most left.

    so in the first loop there are two outputs
    1. not find the result;
    2. find the result and record its successor tree node.
*/

public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode successor = null;
        while(root != null && p.val != root.val) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        if (root == null) {
            return null;
        }

        if (root.right == null) {
            return successor;
        }

        root = root.right;
        while (root.left != null) {
            root = root.left;
        }

        return root;
    }
}
