package LeetCodeAnswer.no218_TheSkylineProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for (int[] b : buildings) {
            height.add(new int[] {b[0], -b[2]});
            height.add(new int[] {b[1], b[2]});
        }
        Collections.sort(height, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] != o2[0]) return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
        	
		});
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(0, new Comparator<Integer>() {
        	@Override
        	public int compare(Integer i1, Integer i2) {
        		return i2 - i1;
        	}
		});
        pq.offer(0);
        int prev = 0;
        for(int[] h : height) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if (prev != cur) {
                result.add(new int[] {h[0], cur});
                prev = cur;
            }
        }
        return result;
    }
}
