package no420StrongPasswordChecker;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int strongPasswordChecker(String s) {
        if (s == null || s.length() == 0) {
            return 6;
        }

        // first three checkers
        int checkL = 0, checkU = 0, checkD = 0;
        // fourth checker for sequences longer than 3
        int checkLen = 0;
        // stores the sequences' length
        Queue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            public int compare(Integer it1, Integer it2) {
                return it1 % 3 - it2 % 3;
            }
        });
        // get the sequences
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= 'z' && s.charAt(i) >= 'a') {
                checkL = 1;
            }
            if (s.charAt(i) <= 'Z' && s.charAt(i) >= 'A') {
                checkU = 1;
            }
            if (s.charAt(i) <= '9' && s.charAt(i) >= '0') {
                checkD = 1;
            }
            if (s.charAt(i) != s.charAt(pos)) {
                int length = i - pos;
                if (length >= 3) {
                    queue.offer(length);
                    checkLen += length / 3;
                }
                pos = i;
            }
        }
        if (pos < s.length()) {
            int length = s.length() - pos;
            if (length >= 3) {
                queue.offer(length);
                checkLen += length / 3;
            }
        }

        if (s.length() < 6) {
            int addLen = 6 - s.length();
            if (checkLen == 1 && checkL + checkU + checkD == 3) {
                return addLen + 1;
            }
            return Math.max(addLen, 3 - (checkL + checkU + checkD));
        } else if (s.length() > 20) {
            int removeLen = s.length() - 20, remove = removeLen;
            while (removeLen > 0 && queue.size() > 0) {
                int top = queue.poll();
                int target = top % 3 + 1;
                if (removeLen < target) {
                    break;
                }
                removeLen -= target;
                if (top - target >= 3) {
                    queue.offer(top - target);
                }
                checkLen--;
            }
            return Math.max(3 - (checkL + checkU + checkD), checkLen) + remove;
        } else {
            return Math.max(3 - (checkL + checkU + checkD), checkLen);
        }
    
    }
}
