package no378_KthSmallestElementInASortedMatrix;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int kthSmallest(final int[][] matrix, int k) {
        int row = matrix.length;
        int col = row == 0 ? 0 : row;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(row, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                return matrix[arr1[0]][arr1[1]] - matrix[arr2[0]][arr2[1]];
            }
        });
        
        for(int i = 0; i < col; i++){
            int[] cur = {0, i};
            pq.offer(cur);
        }
        
        for(int i = 0; i < k - 1; i++){
            int[] cur = pq.poll();
            if(cur[0] == row - 1){
                continue;
            }
            pq.offer(new int[]{cur[0] + 1, cur[1]});
        }
        
        int[] cur = pq.poll();
        return matrix[cur[0]][cur[1]];
    }
}
