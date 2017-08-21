package tree;

public class constantTree {
    static TreeNode root1 = new TreeNode(3);
    static TreeNode node1 = new TreeNode(5);
    static TreeNode node2 = new TreeNode(8);
    static TreeNode node3 = new TreeNode(7);
    static TreeNode node4 = new TreeNode(6);
    static TreeNode node5 = new TreeNode(2);
    static TreeNode node6 = new TreeNode(4);

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
        node5.right = null;
        node6.left = null;
        node6.right = null;
        return root1;
    }

}
