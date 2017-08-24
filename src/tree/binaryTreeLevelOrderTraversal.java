package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        binaryTreeLevelOrderTraversal obj = new binaryTreeLevelOrderTraversal();
        TreeNode root = constantTree.returnRoot();
        System.out.println("level order is: " + obj.levelOrderDFS(root));

    }
    private List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int maxDepth = 0;
        if(root == null) {
            return result;
        }

        while(true) {
            List<Integer> level = new ArrayList<>();
            dfs(root, level, 0, maxDepth);
            if(level.size() == 0) {
                break;
            }
            maxDepth++;
            result.add(level);
        }
        return result;
    }
    private void dfs(TreeNode root, List<Integer> level, int currentDepth, int maxDepth) {
        if(root == null) {
            return;
        }
        if(currentDepth == maxDepth) {
            level.add(root.val);
            return;
        }

        dfs(root.left, level, currentDepth + 1, maxDepth);
        dfs(root.right, level, currentDepth + 1, maxDepth);
    }
    private List<List<Integer>> levelOrderBFS(TreeNode root) {
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
