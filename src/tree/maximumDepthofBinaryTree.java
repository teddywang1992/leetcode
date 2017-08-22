package tree;

public class maximumDepthofBinaryTree {
    public static void main(String[] args) {
        maximumDepthofBinaryTree obj = new maximumDepthofBinaryTree();
        TreeNode test = constantTree.returnRoot();
        System.out.println(obj.maxDepthDivideConquer(test));
    }
    int max = 0;
    private int maxDepthTraverse(TreeNode root) {
        maxDepthTraverseHelper(root, 1);
        return max;
    }
    private void maxDepthTraverseHelper(TreeNode root, int depth) {
        if(root == null) {
            return;
        }
        if(depth > max) {
            max = depth;
        }
        maxDepthTraverseHelper(root.left, depth + 1);
        maxDepthTraverseHelper(root.right, depth + 1);
    }
    private int maxDepthDivideConquer(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = maxDepthDivideConquer(root.left);
        int right = maxDepthDivideConquer(root.right);

        return Math.max(left, right) + 1;
    }
}
