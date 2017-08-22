package tree;

public class lowestCommonAncestorofaBinaryTree {
    public static void main(String[] args) {
        lowestCommonAncestorofaBinaryTree obj = new lowestCommonAncestorofaBinaryTree();
        TreeNode root = constantTree.returnRoot();
        TreeNode left = constantTree.getNode7();
        TreeNode right = constantTree.getNode8();
        System.out.println("The common ancestor is: " + obj.lowestCommonAncestor(root, left, right).val);
    }
    private  TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) {
            return root;
        }
        if(left != null) {
            return left;
        }
        if(right != null) {
            return right;
        }
        return null;
    }
}
