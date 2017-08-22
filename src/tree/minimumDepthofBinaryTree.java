package tree;

public class minimumDepthofBinaryTree {
    public static void main(String[] args) {
        minimumDepthofBinaryTree obj = new minimumDepthofBinaryTree();
        TreeNode root = constantTree.returnRoot();
        System.out.println("This tree's minimum depth is: " + obj.minDepth(root));
    }
    private int minDepth(TreeNode root) {
        int min = Integer.MAX_VALUE;
        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }
        if(root.left != null) {
            min = Math.min(min, minDepth(root.left));
        }
        if(root.right != null) {
            min = Math.min(min, minDepth(root.right));
        }

        return min + 1;
    }
}
