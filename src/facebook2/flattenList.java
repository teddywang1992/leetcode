package facebook2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class flattenList {
    //3.  第一题: flatten nested list (e.g. [1,2,[3,4[5]]])
//    第二题: binary tree level order traversal
//    第三题: 给三个funtions: is_low(), is_mid(), is_high(). 让给一个数组排序, low的放在最前面, mid的放在中间, high的放在最后面.
//            http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=173888&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D2%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
//            'flatten'
//    public class NestedIterator implements Iterator<Integer> {
//        Stack<NestedInteger> content;
//        public NestedIterator(List<NestedInteger> nestedList) {
//            this.content = new Stack<>();
//            for (int i = nestedList.size() - 1; i >= 0; i--) {
//                this.content.push(nestedList.get(i));
//            }
//        }
//
//        @Override
//        public Integer next() {
//            return content.pop().getInteger();
//        }
//
//        @Override
//        public boolean hasNext() {
//            while (!content.isEmpty()) {
//                NestedInteger curNested = content.peek();
//                if (curNested.isInteger()) {
//                    return true;
//                }
//                content.pop();
//                for (int i = curNested.getList().size() - 1; i >= 0; i--) {
//                    content.push(curNested.getList().get(i));
//                }
//            }
//            return false;
//        }
//    }
//
//    //    no Iterator
////'Time complexity: O(n), space complexity: o(n)'
//    public List<Integer> flatten(List<NestedInteger> nestedList) {
//        List<Integer> result = new ArrayList<>();
//        if (nestedList == null) {
//            return result;
//        }
//        Stack<NestedInteger> content = new Stack<>();
//        for (int i = nestedList.size() - 1; i >= 0; i--) {
//            content.push(nestedList.get(i));
//        }
//        while (!content.isEmpty()) {
//            NestedInteger curNested = content.pop();
//            if (curNested.isInteger()) {
//                result.add(curNested.getInteger());
//            }
//            else {
//                for (int i = curNested.getList().size() - 1; i >= 0; i--) {
//                    content.push(curNested.getList().get(i));
//                }
//            }
//        }
//        return result;
//
//    }
    class FlattenList {
        public void flattenPrint(ListNodeRecur head) {
            if (head == null) {
                return;
            }
            while (head != null) {
                System.out.printf("%d ", head.val);
                if (head.branch != null) {
                    flattenPrint(head.branch);
                }
                head = head.next;
            }
        }

        public ListNodeRecur flatten(ListNodeRecur head) {
            if (head == null) {
                return head;
            }
            ListNodeRecur fakeHead = new ListNodeRecur(0);
            helper(head, fakeHead);
            return head;
        }

        private ListNodeRecur helper(ListNodeRecur branch, ListNodeRecur head) {
            head.next = branch;
            ListNodeRecur prev = head;
            while (branch != null) {
                System.out.printf("%d ", branch.val);
                if (branch.branch != null) {
                    ListNodeRecur next = branch.next;
                    ListNodeRecur tail = helper(branch.branch, branch);
                    tail.next = next;
                    branch = next;
                    prev = tail;
                }
                else {
                    prev = prev.next;
                    branch = branch.next;
                }
            }
            return prev;
        }
    }

    class ListNodeRecur {
        public ListNodeRecur next;
        public ListNodeRecur branch;
        public int val;
        public ListNodeRecur(int val) {
            this.val = val;
        }
    }
}
