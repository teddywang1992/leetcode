package microsoft;

import tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) return null;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode helper(int[] inorder, int iLeft, int iRight, int[] postorder, int pLeft, int pRight, Map<Integer, Integer> map) {
        if (pLeft > pRight || pLeft > pRight) return null;
        TreeNode root = new TreeNode(postorder[pRight]);
        int rightIndex = map.get(postorder[pRight]);
        TreeNode left = helper(inorder, iLeft, rightIndex - 1, postorder, pLeft, pLeft + rightIndex - iLeft - 1, map);
        TreeNode right = helper(inorder, rightIndex + 1, iRight, postorder, pLeft + rightIndex - iLeft, pRight - 1, map);
        root.left = left;
        root.right = right;

        return root;
    }
}
