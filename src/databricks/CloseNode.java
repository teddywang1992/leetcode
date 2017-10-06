package databricks;

import tree.TreeNode;
import tree.constantTree;

import static tree.constantTree.node7;

public class CloseNode {
    private TreeNode result;

    public static void main(String[] args) {
        TreeNode root = constantTree.returnRoot();
        System.out.println(getCloseNode(root, node7));
    }

    private static int getCloseNode(TreeNode root, TreeNode k){
        TreeNode ancestors[] = new TreeNode[100];

        return findClosestUtil(root, k, ancestors, 0);
    }
    static int findClosestUtil(TreeNode node, TreeNode k, TreeNode ancestors[], int index) {
        // Base case
        if (node == null)
            return Integer.MAX_VALUE;

        // If key found
        if (node.val == k.val)
        {
            //  Find the cloest leaf under the subtree rooted with given key
            int res = closestDown(node);

            // Traverse all ancestors and update result if any parent node
            // gives smaller distance
            for (int i = index - 1; i >= 0; i--)
                res = Math.min(res, index - i + closestDown(ancestors[i]));
            return res;
        }

        // If key node found, store current node and recur for left and
        // right childrens
        ancestors[index] = node;
        return Math.min(findClosestUtil(node.left, k, ancestors, index + 1),
                findClosestUtil(node.right, k, ancestors, index + 1));

    }

    private static int closestDown(TreeNode node) {
        // Base cases
        if (node == null)
            return Integer.MAX_VALUE;
        if (node.left == null && node.right == null)
            return 0;

        // Return minimum of left and right, plus one
        return 1 + Math.min(closestDown(node.left), closestDown(node.right));
    }



//    public static int closest(TreeNode root, TreeNode target){
//        int[] closest = {Integer.MAX_VALUE};
//        dfs(root, target, closest);
//        return closest[0];
//    }
//
//    private static void dfs(TreeNode root, TreeNode target, int[] closest){
//        if(root == null){
//            return;
//        }
//        if(root.left == null && root.right == null){
//            closest[0] = Math.abs(root.val - target.val) < Math.abs(closest[0] - target.val) ? root.val : closest[0];
//        }
//        dfs(root.left, target, closest);
//        dfs(root.right, target, closest);
//    }
}

