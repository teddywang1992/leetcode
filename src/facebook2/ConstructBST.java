package facebook2;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructBST {
//    9. reconstruct BST from pre-order sequence. (preorder BST)
//    http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=192346&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
//            '######-need iterative method-#########' T(N) = 2 * T(N /2) + O(N) = 4 T(N / 4) + 2 * O(N) = N + lgN * O(N)
//'Time complexity: O(NlgN)'
    public static void main(String[] args) {
        int[] preorder = new int[] {5,3,8,1,4,6,9};
        TreeNode root = construct(preorder);
        System.out.println(root.right.val);
    }

    private static TreeNode construct(int[] preorder) {
        if (preorder == null || preorder.length == 0) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(preorder[0]);
        queue.offer(root);
        for (int i = 1; i < preorder.length; i += 2) {
            TreeNode cur = queue.poll();
            if (i < preorder.length - 1 && preorder[i] < cur.val) {
                TreeNode left = new TreeNode(preorder[i]);
                cur.left = left;
                queue.offer(left);
            }
            if (i < preorder.length - 1 && preorder[i + 1] > cur.val) {
                TreeNode right = new TreeNode(preorder[i + 1]);
                cur.right = right;
                queue.offer(right);
            }
        }
        return root;
    }

    class construcBST {
        public TreeNode constructFromPreorder(int[] preorder) {
            if (preorder.length == 0) {
                return null;
            }
            return constructorHelper(preorder, 0, preorder.length - 1);
        }
        private TreeNode constructorHelper(int[] preorder, int start, int end) {
            TreeNode root = new TreeNode(preorder[start]);
            if (start == end) {
                return root;
            }
            // find the start of right branch
            start++;
            int rightIndex = start;
            while (rightIndex <= end && preorder[rightIndex] < root.val) {
                rightIndex++;
            }
            TreeNode left = null;
            TreeNode right = null;
            if (rightIndex > start) {
                left = constructorHelper(preorder, start, rightIndex - 1);
            }
            if (rightIndex <= end) {
                right = constructorHelper(preorder, rightIndex, end);
            }
            root.left = left;
            root.right = right;
            return root;
        }
    }

}
