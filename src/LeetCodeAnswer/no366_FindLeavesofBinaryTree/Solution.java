package LeetCodeAnswer.no366_FindLeavesofBinaryTree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) {val = x;}
}

public class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        
        while (!isLeaf(root)) { 
            ArrayList<Integer> list = new ArrayList<Integer>();
            dfs(list, root);
            result.add(new ArrayList<Integer>(list));
        }
        ArrayList<Integer> last = new ArrayList<Integer>();
        last.add(root.val);
        result.add(last);
        return result;
    }
    
    private void dfs(ArrayList<Integer> list, TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            if (isLeaf(root.left)) {
                list.add(root.left.val);
                root.left = null;
            } else {
                dfs(list, root.left);
            }
        }
        
        if (root.right != null) {
            if (isLeaf(root.right)) {
                list.add(root.right.val);
                root.right = null;
            } else {
                dfs(list, root.right);
            }
        }
    }
    
    private boolean isLeaf(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        return false;
    }
}