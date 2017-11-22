package LeetCodeAnswer.no447_NumberOfBoomeranges;

import java.util.HashMap;

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length < 3) return 0;
        int res = 0;
        
        for (int i = 0; i < points.length; i++) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                int dis = getDis(points[i], points[j]);
                if (map.containsKey(dis)) res += 2 * map.get(dis);
                //update
                map.put(dis, map.containsKey(dis) ? map.get(dis) + 1 : 1);
            }
        }
        return res;
    }
    private int getDis(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return dx * dx + dy * dy;
    }
}
