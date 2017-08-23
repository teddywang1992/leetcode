package tree;
class MaximumPathSumResultType {
    int any2any;
    int root2any;
    public MaximumPathSumResultType(int any, int root) {
        any2any = any;
        root2any = root;
    }
}

public class binaryTreeMaximumPathSum {
    public static void main(String[] args) {
        binaryTreeMaximumPathSum obj = new binaryTreeMaximumPathSum();
        TreeNode root = constantTree.returnRoot();
        System.out.println("Binary Tree Maximum Path Sum: " + obj.maxPathSum(root));
    }
    private int maxPathSum(TreeNode root) {
        return maxPathSumHelper(root).any2any;
    }
    private MaximumPathSumResultType maxPathSumHelper(TreeNode root) {
        if(root == null) {
            return new MaximumPathSumResultType(Integer.MIN_VALUE, Integer.MIN_VALUE);
        }

        MaximumPathSumResultType left = maxPathSumHelper(root.left);
        MaximumPathSumResultType right = maxPathSumHelper(root.right);

        int root2any = Math.max(0, Math.max(left.root2any, right.root2any)) + root.val;

        int any2any = Math.max(left.root2any, right.root2any);
        any2any = Math.max(any2any, Math.max(0, left.root2any) + Math.max(0, right.root2any) + root.val);

        return new MaximumPathSumResultType(any2any, root2any);
    }
}
