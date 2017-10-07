package intuit;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private class Node {
        int key;
        int val;
        Node next;
        Node pre;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            Node next = null;
            Node pre = null;
        }
    }

    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        Node current = map.get(key);
        current.pre.next = current.next;
        current.next.pre = current.pre;
        moveToTail(current);

        return current.val;
    }

    public void put(int key, int value) {
        if(get(key) != -1) {
            map.get(key).val = value;
            return;
        }

        if (capacity == map.size()) {
            Node current = head.next;
            map.remove(current.key);
            head.next = current.next;
            current.next.pre = head;
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

