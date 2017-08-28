package tree;

public class pathSum {
    public static void main(String[] args) {
        pathSum obj = new pathSum();
        TreeNode root = constantTree.returnRoot();
        System.out.println(obj.hasPathSum(root, 15));
    }
    private boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
