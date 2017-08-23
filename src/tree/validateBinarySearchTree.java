package tree;

class validateBinarySearchTreeResultType {
    boolean isBST;
    int leftMaxValue;
    int rightMinValue;
    validateBinarySearchTreeResultType(boolean BST, int max, int min) {
        isBST = BST;
        leftMaxValue = max;
        rightMinValue = min;
    }
}

public class validateBinarySearchTree {
    public static void main(String[] args) {
        validateBinarySearchTree obj = new validateBinarySearchTree();
        TreeNode BST = constantTree.returnBST();
        TreeNode notBST = constantTree.returnRoot();
        System.out.println("This is a BST: " + obj.isValidBST(BST));
        System.out.println("This is not a BST: " + obj.isValidBST(notBST));
    }
    private boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root).isBST;
    }
    private validateBinarySearchTreeResultType isValidBSTHelper(TreeNode root) {
        if(root == null) {
            return new validateBinarySearchTreeResultType(true, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        validateBinarySearchTreeResultType left = isValidBSTHelper(root.left);
        validateBinarySearchTreeResultType right = isValidBSTHelper(root.right);

        if(!left.isBST || !right.isBST) {
            return new validateBinarySearchTreeResultType(false, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        if((root.left != null && left.leftMaxValue >= root.val) ||
                (root.right != null && right.rightMinValue <= root.val)) {
            return new validateBinarySearchTreeResultType(false, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        return new validateBinarySearchTreeResultType(true,
                Math.max(root.val, right.leftMaxValue),
                Math.max(root.val, left.rightMinValue));
    }
}
