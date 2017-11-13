package FacebookInterview;

/*

在职跳槽，没有太复习，全程互动不错的，面试官迟到了十分钟，也没有相应延时，所以整个面试过程撑死了就半个小时多一点点，以为应该过了吧，至少再磨
一轮电面没什么问题，然而。。。
1. 写一个binary tree in order traversal
2. 要求in place把一个binary tree按照in order的次序变成linkedlist， 就是node的left指向previous，right指向next，要求一定是in place
3. 变成double linked list
4. 变成circular linked list
最后要求分析复杂度，现在一边打字一边想是不是复杂度分析错了，time complexity没有问题，space complexity因为是in place的写法，就是o(1)啊
，面试官一直在说你要不要再考虑一下，我说一般分析复杂度不考虑input对吧，那in place的写法难道不是1， 还是说要考虑recursive的过程？
 比如说每次recursion 都要建立一个temp的话，那就是recursive的次数？这些我都说了啊
 */

import linkedList.ListNode;
import tree.TreeNode;
import tree.constantTree;

import java.util.*;

public class BSTdoublelinkedlist {
    public static void main(String[] args) {
        TreeNode root = constantTree.returnBST();
        ListNode head = BSTtoLink(root);
        while (head.next != null) {
            head = head.next;
        }
        while (head.pre != null) {
            System.out.println(head.val);
            head = head.pre;
        }
    }

    private static ListNode BSTtoLink (TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            ListNode cur = new ListNode(root.val);
            cur.pre = head;
            head.next = cur;
            head = head.next;
            root = root.right;
        }
        return dummy.next;
    }
}
