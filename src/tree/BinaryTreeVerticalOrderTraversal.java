package tree;

import java.util.*;

/*
一个队列保存node 一个队列保存左右的标号，
注意更新queue里面的值不要把curTree写成root.
*/

public class BinaryTreeVerticalOrderTraversal {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> treeQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        int max = 0;
        int min = 0;

        treeQueue.offer(root);
        levelQueue.offer(0);

        while (!treeQueue.isEmpty()) {
            TreeNode curTree = treeQueue.poll();
            int level = levelQueue.poll();

            if (!levelMap.containsKey(level)) {
                levelMap.put(level, new ArrayList<>());
            }
            levelMap.get(level).add(curTree.val);

            if (curTree.left != null) {
                treeQueue.offer(curTree.left);
                levelQueue.offer(level - 1);
                min = Math.min(min, level - 1);
            }

            if (curTree.right != null) {
                treeQueue.offer(curTree.right);
                levelQueue.offer(level + 1);
                max = Math.max(max, level + 1);
            }
        }

        for (; min <= max; min++) {
            result.add(levelMap.get(min));
        }

        return result;
    }
}
