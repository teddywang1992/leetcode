package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class binaryTreePostorderTraversal {
    public static void main(String[] args) {
        binaryTreePostorderTraversal obj = new binaryTreePostorderTraversal();
        TreeNode test = constantTree.returnRoot();
        System.out.println(obj.postorderTraverslStack(test));
    }
    private List<Integer> postorderTraversalRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        traverse(root, result);

        return result;
    }
    private void traverse(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }
        traverse(root.left, result);
        traverse(root.right, result);
        result.add(root.val);
    }

    private List<Integer> postorderTraversalDivideConquer(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        List<Integer> left = postorderTraversalDivideConquer(root.left);
        List<Integer> right = postorderTraversalDivideConquer(root.right);

        result.addAll(left);
        result.addAll(right);
        result.add(root.val);

        return result;
    }
    private List<Integer> postorderTraverslStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null) {
            return result;
        }

        TreeNode cur = root;
        TreeNode pre = null;
        stack.push(cur);

        while(!stack.empty()) {
            cur = stack.peek();
            if(pre == null || pre.right == cur || pre.left == cur) {
                if(cur.left != null) {
                    stack.push(cur.left);
                } else if (cur.right != null) {
                    stack.push(cur.right);
                }
            } else if(cur.left == pre) {
                if(cur.right != null) {
                    stack.push(cur.right);
                }
            } else {
                result.add(cur.val);
                stack.pop();
            }
            pre = cur;
        }
        return result;
    }
}
