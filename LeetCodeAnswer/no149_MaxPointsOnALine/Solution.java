package no149_MaxPointsOnALine;

import java.util.HashMap;

class Point {
	int x;
	int y;

	Point() {
		x = 0;
		y = 0;
	}

	Point(int a, int b) {
		x = a;
		y = b;
	}
}

public class Solution {
    
    private int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd (b % a, a);
    }
    
    public int maxPoints(Point[] points) {
        if (points == null || points.length == 0) return 0;
		if (points.length <= 2) return points.length;
		int res = 0;
		for (int i = 0; i < points.length; i++) {
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int sameX = 1;
			int sameP = 0;
			for (int j = 0; j < points.length; j++) {
				if (i == j)
					continue;
				if (points[i].x == points[j].x && points[i].y == points[j].y)
					sameP++;
				if (points[i].x == points[j].x) {
					sameX++;
					continue;
				}
				
			    int numerator = points[j].y - points[i].y;
                int denaminator = points[j].x - points[i].x;
                int gcd = gcd(numerator, denaminator);
                String hashStr = (numerator/gcd) + "_" + (denaminator/gcd);
				if (map.containsKey(hashStr)) {
					map.put(hashStr, map.get(hashStr) + 1);
				} else {
					map.put(hashStr, 2);
				}
				res = Math.max(res, map.get(hashStr) + sameP);
			}
			res = Math.max(res, sameX);
		}
		return res;
    }
}