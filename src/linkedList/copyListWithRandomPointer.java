package linkedList;

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { this.label = x; }
}

public class copyListWithRandomPointer {
    private static RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(0);
        RandomListNode pre = dummy;
        RandomListNode newNode;

        while(head != null) {
            if(map.containsKey(head)) {
                newNode = map.get(head);
            } else {
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            pre.next = newNode;

            if(head.random != null) {
                if(map.containsKey(head.random)) {
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }

            pre = newNode;
            head = head.next;
        }
        return dummy.next;
    }
}
