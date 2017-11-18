package FacebookInterview;

import linkedList.ListNode;

import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null) return 0;
        PriorityQueue<Point> heap = new PriorityQueue<>((p1, p2) -> (p1.val - p2.val));
        for (int i = 0; i < matrix[0].length; i++) {
            heap.offer(new Point(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k - 1; i++) {
            Point cur = heap.poll();
            if (cur.x == matrix.length - 1) continue;
            heap.offer(new Point(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
        }
        return heap.poll().val;
    }

    class Point{
        int x;
        int y;
        int val;
        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
