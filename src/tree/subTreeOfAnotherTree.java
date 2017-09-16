package tree;

public class subTreeOfAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t != null) {
            return false;
        }

        if (sameTree(s, t)) {
            return true;
        }

        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean sameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if ((p == null && q != null) || (q == null && p != null)) {
            return false;
        }

        if (p.val == q.val) {
            return sameTree(p.left, q.left) && sameTree(p.right, q.right);
        }

        return false;
    }
}
