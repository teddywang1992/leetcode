package microsoft;

import linkedList.ListNode;

import java.util.Stack;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }

        int sum = 0;
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int val1 = stack1.isEmpty() ? 0 : stack1.pop().val;
            int val2 = stack2.isEmpty() ? 0 : stack2.pop().val;
            sum = (val1 + val2 + carry) % 10;
            carry = (val1 + val2 + carry) / 10;
            ListNode node = new ListNode(sum);
            node.next = dummy.next;
            dummy.next = node;
        }

        return dummy.next;
    }
}
