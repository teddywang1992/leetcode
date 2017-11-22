package Amazon;

import java.util.PriorityQueue;
import java.util.Comparator;
class Point {
	int x;
	int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
public class kNearestPoints {
    public Point[] Solution(Point[] array, final Point origin, int k) {
        Point[] res = new Point[k];
        int index = 0;
        PriorityQueue<Point> pq = new PriorityQueue<Point> (k, new Comparator<Point> () {
            public int compare(Point a, Point b) {
                return (int) (getDistance(a, origin) - getDistance(b, origin));
            }
        });
        
        for (int i = 0; i < array.length; i++) {
            pq.offer(array[i]);
            if (pq.size() > k)
                pq.poll();
        }
        while (!pq.isEmpty())
            res[index++] = pq.poll();
        return res;
    }
    private double getDistance(Point a, Point b) {
        return Math.sqrt((a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y));
    }
}