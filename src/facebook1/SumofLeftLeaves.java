package facebook1;

import tree.TreeNode;

public class SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left != null && root.left.left == null && root.left.right == null){
            return root.left.val + sumOfLeftLeaves(root.right);
            //  return root.left.val + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);可以把左边删掉
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
