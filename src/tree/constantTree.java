package tree;

/*                         3
                        /     \
                       5       8
                      / \     / \
                     7   6   2   4
                              \
                               9
                                \
                                 10
*/

/*
                        _______7______
                       /              \
                    ___3__          ___9__
                   /      \        /      \
                   2      _5       8       10
                         /  \
                         4   6
*/
class constantTree {
    private static TreeNode root1 = new TreeNode(3);
    private static TreeNode node1 = new TreeNode(5);
    private static TreeNode node2 = new TreeNode(8);
    private static TreeNode node3 = new TreeNode(7);
    private static TreeNode node4 = new TreeNode(6);
    private static TreeNode node5 = new TreeNode(2);
    private static TreeNode node6 = new TreeNode(4);
    private static TreeNode node7 = new TreeNode(9);
    private static TreeNode node8 = new TreeNode(10);

    public static TreeNode returnBST() {
        node6.left = null;
        node6.right = null;
        node4.left = null;
        node4.right = null;
        node5.left = null;
        node5.right = null;
        node2.left = null;
        node2.right = null;
        node8.left = null;
        node8.right = null;
        node3.left = root1;
        node3.right = node7;
        root1.left = node5;
        root1.right = node1;
        node7.left = node2;
        node7.right = node8;
        node1.left = node6;
        node1.right = node4;
        return node3;
    }

    public static TreeNode returnRoot() {
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = null;
        node3.right = null;
        node4.left = null;
        node4.right = null;
        node5.left = null;
        node5.right = node7;
        node6.left = null;
        node6.right = null;
        node7.left = null;
        node7.right = node8;
        node8.left = null;
        node8.right = null;
        return root1;
    }


    public static TreeNode returnBalanceTree() {
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node3.left = null;
        node3.right = null;
        node4.left = null;
        node4.right = null;
        node5.left = null;
        node5.right = null;
        node6.left = null;
        node6.right = null;
        return node1;
    }
    public static TreeNode getNode1() {
        return node1;
    }
    public static TreeNode getNode2() {
        return node2;
    }
    public static TreeNode getNode3() {
        return node3;
    }
    public static TreeNode getNode4() {
        return node4;
    }
    public static TreeNode getNode5() {
        return node5;
    }
    public static TreeNode getNode6() {
        return node6;
    }
    public static TreeNode getNode7() {
        return node7;
    }
    public static TreeNode getNode8() {
        return node8;
    }
}


