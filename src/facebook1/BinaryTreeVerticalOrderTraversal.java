package facebook1;

import tree.TreeNode;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> treeQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        int max = 0, min = 0;

        treeQueue.offer(root);
        levelQueue.offer(0);
        while (!treeQueue.isEmpty()) {
            TreeNode curTree = treeQueue.poll();
            int curLevel = levelQueue.poll();
            levelMap.putIfAbsent(curLevel, new ArrayList<>());
            levelMap.get(curLevel).add(curTree.val);

            if (curTree.left != null) {
                treeQueue.offer(curTree.left);
                levelQueue.offer(curLevel - 1);
                min = Math.min(min, curLevel - 1);
            }

            if (curTree.right != null) {
                treeQueue.offer(curTree.right);
                levelQueue.offer(curLevel + 1);
                max = Math.max(max, curLevel + 1);
            }
        }

        for ( ; min <= max; min++) {
            result.add(levelMap.get(min));
        }

        return result;
    }
}
