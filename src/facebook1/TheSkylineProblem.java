package facebook1;

import java.util.*;

public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        for (int[] building : buildings) {
            heights.add(new int[] {building[0], -building[2]});
            heights.add(new int[] {building[1], building[2]});
        }

        Collections.sort(heights, (h1, h2) -> (h1[0] != h2[0] ? h1[0] - h2[0] : h1[1] - h2[1]));
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> (b - a));
        heap.offer(0);
        int pre = 0;
        for (int[] height : heights) {
            if (height[1] < 0) heap.offer(-height[1]);
            else heap.remove(height[1]);
            int cur = heap.peek();
            if (cur != pre) {
                result.add(new int[] {height[0],cur});
                pre = cur;
            }
        }

        return result;
    }
}
