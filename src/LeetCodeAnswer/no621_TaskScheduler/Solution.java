package LeetCodeAnswer.no621_TaskScheduler;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.List;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
        	public int compare(Integer i1, Integer i2) {
        		return i2 - i1;
        	}
		});
        pq.addAll(map.values());
        int res = 0, cycle = n + 1;
        while (!pq.isEmpty()) {
            List<Integer> temp = new ArrayList<Integer>();
            int workTime = 0;
            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    temp.add(pq.poll());
                    workTime++;
                }
            }
            for (int num : temp) {
                if (--num > 0) pq.offer(num);
            }
            if (pq.isEmpty()) {
                res += workTime;
            } else {
                res += cycle;
            }
        }
        return res;
    }
}