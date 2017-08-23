package tree;

import java.util.Stack;

public class binarySearchTreeIterator {
    public static void main(String[] args) {
        TreeNode BST = constantTree.returnBST();
        BSTIterator iterator = new BSTIterator(BST);
        System.out.println("test hasNext: " + iterator.hasNext());
        System.out.println("test next: " + iterator.next());
    }
}
class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode next = null;

    BSTIterator(TreeNode root) {
        next = root;
    }
    boolean hasNext() {
        if(next != null) {
            while(next != null) {
                stack.push(next);
                next = next.left;
            }
            next = null;
        }
        return !stack.isEmpty();
    }
    int next() {
        TreeNode current = stack.pop();
        next = current.right;
        return current.val;
    }
}
