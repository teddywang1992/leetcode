package facebook1;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    Node head;
    Node tail;
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        node.next.pre = node.pre;
        node.pre.next = node.next;
        moveToTail(node);
        return node.value;
    }

    private void moveToTail(Node node) {
        Node last = tail.pre;
        last.next = node;
        node.pre = last;
        node.next = tail;
        tail.pre = node;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }
        if (map.size() == capacity) {
            Node node = head.next;
            map.remove(node.key);
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        Node node = new Node(key, value);
        map.put(key, node);
        moveToTail(node);
    }
}
