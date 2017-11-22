package no146_LRUCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class DLLNode {
        DLLNode prev, next;
        int value;
        int key;
        
        public DLLNode(int value, int key) {
            this.value = value;
            this.key = key;
        }
    }

    Map<Integer, DLLNode> keyMap = new HashMap<Integer, DLLNode>();
    DLLNode head;
    DLLNode tail;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!keyMap.containsKey(key)) {
            return -1;
        }
        
        DLLNode node = keyMap.get(key);
        moveToFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (keyMap.containsKey(key)) {
            DLLNode node = keyMap.get(key);
            node.value = value;
            moveToFront(node);
            return;
        }
        
        if (capacity == 0) {
            removeLastNode();
        } else {
            capacity--;
        }
        
        DLLNode newNode = new DLLNode(value, key);
        keyMap.put(key, newNode);
        addNode(newNode);
    }
    
    private void addNode(DLLNode node) {
        if (head == null && tail == null) {
            head = node;
            tail = head;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
    
    private void removeLastNode() {
        if (tail == null) {
            return;
        }
        
        keyMap.remove(tail.key);
        if (tail == head) {
            tail = null;
            head = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
    }
    
    private void moveToFront(DLLNode node) {
        if (node == head) {
            return;
        }
        
        if (node == tail) {
            tail = tail.prev;
            tail.next = null;
        }
        
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        
        node.prev.next = node.next;
        node.prev = null;
        node.next = head;
        head.prev = node;
        head = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */