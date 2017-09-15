package tree;
//求两边树的深度相加
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int length = getHeight(root.left) + getHeight(root.right);
        length = Math.max(length, Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
        return length;
    }

    private int getHeight(TreeNode root) {
        int height = 0;
        if (root == null) {
            return height;
        }
        height = Math.max(getHeight(root.left) + 1, getHeight(root.right) + 1);
        return height;
    }
}
