package intuit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rectangle {
    public static void main(String[] args) {
        int[][] image = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 1, 1},
                {1, 1, 1, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 1, 0},
        };
        List<Point> result = findRectangle(image);
        for (Point point : result) {
            System.out.println(point.x);
            System.out.println(point.y);
        }
    }

    private static List<Point> findRectangle(int[][] image) {
        List<Point> result = new ArrayList<>();

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (image[i][j] == 0) {
                    result.add(new Point(i, j));
                    bfs(image, i, j, result);
                    return result;
                }
            }
        }
        return result;
    }

    private static void bfs(int[][] image, int i, int j, List<Point> result) {
        Queue<Point> queue = new LinkedList<>();
        Point point = new Point(i, j);

        queue.offer(point);
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (image[current.x + 1][current.y] != 0 && image[current.x][current.y + 1] != 0) {
                result.add(new Point(current.x, current.y));
                return;
            }
            if (image[current.x + 1][current.y] == 0) queue.offer(new Point(current.x + 1, current.y));
            if (image[current.x][current.y + 1] == 0) queue.offer(new Point(current.x, current.y + 1));
        }
    }
    static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
