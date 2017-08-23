package tree;

class BalanceResultType {
    int maxDepth;
    boolean isBalanced;
    BalanceResultType(boolean balance, int depth) {
        maxDepth = depth;
        isBalanced = balance;
    }
}

public class balancedBinaryTree {
    public static void main(String[] args) {
        balancedBinaryTree obj = new balancedBinaryTree();
        TreeNode balanceTree = constantTree.returnBalanceTree();
        TreeNode notBalanceTree = constantTree.returnRoot();
        System.out.println("This is a balance tree:" + obj.isBalanceWithResultType(balanceTree));
        System.out.println("This is not a balance tree: " + obj.isBalanceWithResultType(notBalanceTree));
    }
    private boolean isBalanceWithResultType (TreeNode root) {
        return isBalanceWithResultTypeHelper(root).isBalanced;
    }
    private BalanceResultType isBalanceWithResultTypeHelper(TreeNode root) {
        if(root == null) {
            return new BalanceResultType(true, 0);
        }

        BalanceResultType left = isBalanceWithResultTypeHelper(root.left);
        BalanceResultType right = isBalanceWithResultTypeHelper(root.right);

        if(!left.isBalanced || !right.isBalanced) {
            return new BalanceResultType(false, -1);
        }
        if(Math.abs(left.maxDepth - right.maxDepth) > 1) {
            return new BalanceResultType(false, -1);
        }
        return new BalanceResultType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
    }
    private boolean isBalanceWithoutResultType(TreeNode root) {
        return isBalanceWithoutResultTypeHelper(root) != -1;
    }
    private int isBalanceWithoutResultTypeHelper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = isBalanceWithoutResultTypeHelper(root.left);
        int right = isBalanceWithoutResultTypeHelper(root.right);

        if(left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
