package facebook1;

//Each node will be visited at most twice-> average O(1) run time.
//The stack will store at most h nodes -> O(h) space.

import tree.TreeNode;

import java.util.Stack;

public class BinarySearchTreeIterator {
    private Stack<TreeNode> stack;
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode cur = node;
        if (cur != null) {
            if (cur.right != null) {
                stack.push(cur.right);
                cur = cur.right;
                while (cur.left != null) {
                    stack.push(cur.left);
                    cur = cur.left;
                }
            }
        }

        return node.val;
    }
}
