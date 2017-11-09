package facebook2;

import java.util.*;

public class nearestKPoints {
//    #6. nearest k point;
//    decode ways, optimize space complexity to O(1)
//
//    Nearest Kth
// Use quickSelect to find the kth nearest point to the origin point
//'Time complexity: average O(n), worst O(n^2) when always pick the most right one -- the time complexity of quick select'
    class NearestKPoint {
        public Point findNearestKthPoint(Point[] points, int k) {
            if (k > points.length || k == 0) {
                throw new IllegalArgumentException("K's value is illegal\n");
            }
            return quickSelect(points, 0, points.length - 1, k - 1);
        }


        private Point quickSelect(Point[] points, int left, int right, int k) {
            Random rand = new Random();
            int pivotIndex = 0;
            if (right != 0) {
                pivotIndex = rand.nextInt(right) % (right - left + 1) + left;
            }
            pivotIndex = partition(pivotIndex, points, left, right);
            if (pivotIndex == k) {
                return points[k];
            }
            else if (pivotIndex > k) {
                return quickSelect(points, left, pivotIndex - 1, k);
            }
            else {
                return quickSelect(points, pivotIndex + 1, right, k);
            }
        }

        private int partition(int pivotIndex, Point[] points, int left, int right) {
            int i = left;
            int j = right;
            Point temp = points[pivotIndex];
            int tempDistance = distance(temp);
            swap(points, left, pivotIndex);
            while (i < j) {
                while (j > i && distance(points[j]) >= tempDistance) {
                    j--;
                }
                points[i] = points[j];
                while (j > i && distance(points[i]) <= tempDistance) {
                    i++;
                }
                points[j] = points[i];
            }
            points[i] = temp;
            return i;
        }

        private int distance(Point point) {
            return point.x * point.x + point.y * point.y;
        }

        private void swap (Point[] points, int index1, int index2) {
            Point temp = points[index1];
            points[index1] = points[index2];
            points[index2] = temp;
        }
    }

    class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

// Use max Heap
// maintain a max heap with size K,
// every time meet a new point, check if its distance is
// smaller than the heap.peek()
// if yes, pop out the peek, push this point into heap
// in the end we will have K points which are the nearest points
//'Time complexity: O(nlgk), space complexity:O(k)'
    public List<Point> findNearestKPoints(Point[] points, int k) {
        if (k <= 0 || k > points.length) {
            throw new IllegalArgumentException("K's value is illegal.\n");
        }
        List<Point> result = new ArrayList<>();
        PriorityQueue<Point> maxPoints = new PriorityQueue<>(k, (poi1, poi2) -> distance(poi2) - distance(poi1));
        for (Point point : points) {
            if (maxPoints.size() < k) {
                maxPoints.add(point);
            }
            else if (distance(maxPoints.peek()) > distance(point)) {
                maxPoints.poll();
                maxPoints.add(point);
            }
        }
        while (!maxPoints.isEmpty()) {
            result.add(maxPoints.poll());
        }
        return result;
    }
    private int distance(Point p) {
        return p.x * p.x + p.y * p.y;
    }
}
