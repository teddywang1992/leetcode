package microsoft;

public class CopyListwithRandomPointer {
//    public RandomListNode copyRandomList(RandomListNode head) {
//        if (head == null) return null;
//        Map<RandomListNode, RandomListNode> map = new HashMap<>();
//        RandomListNode dummy = new RandomListNode(-1);
//        RandomListNode pre = dummy;
//        RandomListNode newNode;
//
//        while (head != null) {
//            if (map.containsKey(head)) {
//                newNode = map.get(head);
//            } else {
//                newNode = new RandomListNode(head.label);
//                map.put(head, newNode);
//            }
//            pre.next = newNode;
//
//            if (head.random != null) {
//                if (map.containsKey(head.random)) {
//                    newNode.random = map.get(head.random);
//                } else {
//                    newNode.random = new RandomListNode(head.random.label);
//                    map.put(head.random, newNode.random);
//                }
//            }
//
//            pre = newNode;
//            head = head.next;
//        }
//
//        return dummy.next;
//    }
}
