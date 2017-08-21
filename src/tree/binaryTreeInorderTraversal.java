package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class binaryTreeInorderTraversal {
    public static void main(String[] args) {
        binaryTreeInorderTraversal obj = new binaryTreeInorderTraversal();
        TreeNode root = constantTree.returnRoot();
        System.out.println(obj.inorderTraversalDivideConquer(root));
    }
    private List<Integer> inorderTraversalStack(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if(root == null) {
            return result;
        }

        TreeNode node = root;
        while(node != null || !stack.empty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }

    private List<Integer> inorderTraversalDivideConquer(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        List<Integer> left = inorderTraversalDivideConquer(root.left);
        List<Integer> right = inorderTraversalDivideConquer(root.right);

        result.addAll(left);
        result.add(root.val);
        result.addAll(right);

        return result;
    }

    private List<Integer> inorderTraversalRecursion(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        traverse(root, result);
        return result;
    }
    private void traverse(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }
        traverse(root.left, result);
        result.add(root.val);
        traverse(root.right, result);
    }
}
