package dataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class kthSmallestElementInASortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        System.out.println(kthSmallest(matrix, 8));
    }

    private static class Pair {
        int x;
        int y;
        int val;
        public Pair(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    private static class PairComparator implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return a.val - b.val;
        }
    }

    private static int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return Integer.MIN_VALUE;
        }

        int[] dx = {1, 0};
        int[] dy = {0, 1};
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] hashMap = new boolean[m][n];
        Queue<Pair> heap = new PriorityQueue<>(k, new PairComparator());
        heap.add(new Pair(0, 0, matrix[0][0]));

        for (int i = 0; i < k - 1; i++) {
            Pair current = heap.poll();
            for (int j = 0; j < 2; j++) {
                int nextX = current.x + dx[j];
                int nextY = current.y + dy[j];
                Pair pair = new Pair(nextX, nextY, 0);
                if (nextX < m && nextY < n && !hashMap[nextX][nextY]) {
                    hashMap[nextX][nextY] = true;
                    pair.val = matrix[nextX][nextY];
                    heap.add(pair);
                }
            }
        }

        return heap.poll().val;

    }
}
