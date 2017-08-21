package tree;

/*        3
       5    8
     7  6  2  4
*/
class constantTree {
    private static TreeNode root1 = new TreeNode(3);
    private static TreeNode node1 = new TreeNode(5);
    private static TreeNode node2 = new TreeNode(8);
    private static TreeNode node3 = new TreeNode(7);
    private static TreeNode node4 = new TreeNode(6);
    private static TreeNode node5 = new TreeNode(2);
    private static TreeNode node6 = new TreeNode(4);

    static TreeNode returnRoot() {
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
        return root1;
    }

}
