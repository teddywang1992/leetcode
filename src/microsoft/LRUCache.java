package microsoft;

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
    int capacity;

    private Node head;
    private Node tail;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        map = new HashMap<>();
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node cur = map.get(key);
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;

        moveToTail(cur);
        return cur.value;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        if (map.size() == capacity) {
            Node cur = head.next;
            map.remove(cur.key);
            cur.next.pre = head;
            head.next = cur.next;
        }

        Node insert = new Node(key, value);
        map.put(key, insert);
        moveToTail(insert);
    }

    private void moveToTail(Node node) {
        node.pre = tail.pre;
        node.next = tail;
        tail.pre.next = node;
        tail.pre = node;
    }
}
