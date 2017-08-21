package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class binaryTreePreorderTraversal {
    public static void main(String[] args) {
        binaryTreePreorderTraversal obj = new binaryTreePreorderTraversal();
        TreeNode root = constantTree.returnRoot();
        List<Integer> testTraverse = obj.preorderTraversal1(root);
        List<Integer> testDevideConquer = obj.preorderTraversal2(root);
        List<Integer> testStack = obj.preorderTraversal3(root);
        System.out.println(testStack);
    }
    //traverse
    private List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
    private void traverse(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
    //divide conquer
    private List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        List<Integer> left = preorderTraversal2(root.left);
        List<Integer> right = preorderTraversal2(root.right);

        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }

    //non-recursion
    private List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return result;
        }

        stack.push(root);
        while(!stack.empty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if(node.right != null) {
                stack.push(node.right);
            }
            if(node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }
}
