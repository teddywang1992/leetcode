package microsoft;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) return null;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    private TreeNode helper(int[] preorder, int pLeft, int pRight, int[] inorder, int iLeft, int iRight, Map<Integer, Integer> map) {
        if (pLeft > pRight || iLeft > iRight) return null;
        TreeNode root = new TreeNode(preorder[pLeft]);
        int index = map.get(preorder[pLeft]);
        TreeNode left = helper(preorder, pLeft + 1, pLeft + index - iLeft, inorder, iLeft, index - 1, map);
        TreeNode right = helper(preorder, pLeft + index - iLeft + 1, pRight, inorder, index + 1, iRight, map);
        root.left = left;
        root.right = right;

        return root;
    }
}
