package tree;

public class lowestCommonAncestorofaBinarySearchTree {
    public static void main(String[] args) {
        lowestCommonAncestorofaBinarySearchTree obj = new lowestCommonAncestorofaBinarySearchTree();
        TreeNode root = constantTree.returnBST();
        TreeNode left = constantTree.getNode4();
        TreeNode right = constantTree.getNode6();
        System.out.println("ancestor is: " + obj.lowestCommonAncestor(root, left, right).val);
    }
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            int i = 0;
            return root;
        }
    }
}
