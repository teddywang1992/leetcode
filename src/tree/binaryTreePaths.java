package tree;

import java.util.ArrayList;
import java.util.List;

public class binaryTreePaths {
    public static void main(String[] args) {
        TreeNode root = constantTree.returnRoot();
        System.out.println(binaryTreePathsFunction(root));
    }
    public static List<String> binaryTreePathsFunction(TreeNode root) {
        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        List<String> leftPath = binaryTreePathsFunction(root.left);
        List<String> rightPath = binaryTreePathsFunction(root.right);

        for (String path : leftPath) {
            result.add(root.val + "->" + path);
        }

        for (String path : rightPath) {
            result.add(root.val + "->" + path);
        }

        if (root.right == null && root.left == null) {
            result.add("" + root.val);
        }

        return result;
    }
}
