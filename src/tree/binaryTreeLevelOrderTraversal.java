package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        binaryTreeLevelOrderTraversal obj = new binaryTreeLevelOrderTraversal();
        TreeNode root = constantTree.returnRoot();
        System.out.println("level order is: " + obj.levelOrder(root));

    }
    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) {
            return null;
        }

        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                list.add(head.val);
                if(head.left != null) {
                    queue.offer(head.left);
                }
                if(head.right != null) {
                    queue.offer(head.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
