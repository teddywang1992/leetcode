package tree;

public class sumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode root = constantTree.returnBST();
        System.out.println(sumOfLeftLeaves(root));
    }
    private static int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int sum = 0;
        if (root.left != null) {
            TreeNode left = root.left;
            if (left.right == null && left.left == null) {
                sum += left.val;
            } else {
                sum += sumOfLeftLeaves(left);
            }
        }

        if (root.right != null) {
            TreeNode right = root.right;
            sum += sumOfLeftLeaves(right);
        }

        return sum;
    }
}
