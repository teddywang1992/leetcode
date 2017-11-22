package no604_DesignCompressedStringIterator;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    
    Queue<int[]> queue = new LinkedList<>();
    
    public Solution(String compressedString) {
        int i = 0, n = compressedString.length();
        while (i < n) {
            int j = i + 1, num = 0;
            while (j < n && Character.isDigit(compressedString.charAt(j))) {
                num = num * 10 + compressedString.charAt(j++) - '0';
            }
            queue.offer(new int[]{compressedString.charAt(i) - 'a', num});
            i = j;
        }
    }
    
    public char next() {
        if (queue.isEmpty()) return ' ';
        int[] top = queue.peek();
        if (--top[1] == 0) queue.poll();
        return (char)(top[0] + 'a');
    }
    
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */