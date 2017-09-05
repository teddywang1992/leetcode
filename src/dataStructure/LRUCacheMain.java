package dataStructure;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheMain {
    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);
        cache.put(1, 11);
        cache.put(2, 22);
        System.out.println(cache.get(1));
        cache.put(3, 33);
        System.out.println(cache.get(2));
        cache.put(4, 44);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}

class LRUCache2 {
    private class Node {
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }

    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    public void put(int key, int value) {
        if(get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        if(map.size() == capacity) {
            map.remove(key);
            head.next = head.next.next;
            head.next.pre = head;
        }

        Node insert = new Node(key, value);
        map.put(key, insert);
        moveToTail(insert);
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node current = map.get(key);
        moveToTail(current);
        return current.value;
    }

    private void moveToTail(Node current) {
        current.pre = tail.pre;
        tail.pre = current;
        current.next = tail;
        current.pre.next = current;
    }
}
class LRUCache1 {
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCache1(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    public void set(int key, int value) {
        map.put(key, value);
    }
}
