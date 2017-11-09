package facebook2;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class printPath {
//    question2:
//    For a given a binary tree, print paths from root to all leaf nodes, one path per line.
//
//    For tree:
//    A
//        / \
//    B   C
//      /   / \
//    D   E   F
//
//            ABD
//    ACE
//            ACF
//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=171687&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
    // do the transic every day
// when today's prices is higher than yesterday
// if pricse keep increase, the result will be the same as buy at first day and
// sell at last day


//    print path to leaf (BT path leaf)
//
//    iterative method
    private List<String> findPath(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, ""));
        while (!stack.isEmpty()) {
            Pair pair = stack.pop();
            TreeNode node = pair.node;
            String path = pair.path + "->" + Integer.toString(node.val);
            if (node.left == null && node.right == null) {
                result.add(path.substring(2));
            }
            if (node.left != null) {
                stack.push(new Pair(node.left, path));
            }
            if (node.right != null) {
                stack.push(new Pair(node.right, path));
            }
        }
        return result;
    }

    class Pair {
        TreeNode node;
        String path;
        public Pair(TreeNode node, String path) {
            this.node = node;
            this.path = path;
        }
    }

//    recursive method
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        explorePath(root, result, new StringBuilder());
        return result;
    }
    private void explorePath(TreeNode root, List<String> result, StringBuilder path) {
        path.append("->" + Integer.toString(root.val));
        if (root.left == null && root.right == null) {
            result.add(path.substring(2).toString());
            return;
        }
        if (root.left != null) {
            explorePath(root.left, result, new StringBuilder(path.toString()));
        }
        if (root.right != null) {
            explorePath(root.right, result, new StringBuilder(path.toString()));
        }
    }

    class PrintByColumn {
        private int mostLeft = 0;
        public void print(TreeNode root) {
            List<List<Pair>> paths = new ArrayList<>();
            helper(root, 0, new ArrayList<Pair>(), paths);
            for (List<Pair> path : paths) {
                for (Pair pair : path) {
                    int gap = -mostLeft - (-pair.col);
                    while (gap > 0) {
                        System.out.print("*");
                        gap--;
                    }
                    System.out.print(pair.val);
                }
                System.out.println();
            }
        }
        private void helper(TreeNode root, int col, List<Pair> list, List<List<Pair>> paths) {
            list.add(new Pair(root.val, col));
            mostLeft = Math.min(mostLeft, col);
            if (root.left == null && root.right == null) {
                paths.add(new ArrayList<Pair>(list));
            }
            if (root.left != null) {
                helper(root.left, col - 1, list, paths);
            }
            if (root.right != null) {
                helper(root.right, col + 1, list, paths);
            }
            list.remove(list.size() - 1);
        }
        class Pair {
            int col;
            int val;
            public Pair(int val, int col) {
                this.val = val;
                this.col = col;
            }
        }
    }
}
