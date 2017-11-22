package no261_GraphValidTree;

import java.util.Arrays;

public class Solution {
    public static boolean validTree(int n, int[][] edges) {
        // initialize n isolated islands
        if (edges.length != n - 1) return false;
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        
        // perform union find
        for (int i = 0; i < edges.length; i++) {
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            System.out.println("x: " + x + " y: " + y);
            // if two vertices happen to be in the same set
            // then there's a cycle
            if (x == y) return false;
            
            // union
            nums[x] = y;
        }
        
        return true;
    }
    
    private static int find(int nums[], int i) {
        if (nums[i] == -1) return i;
        return find(nums, nums[i]);
    }
    
    public static void main(String[] args) {
		int[][] edges = new int[4][2];
		edges[0] = new int[]{0, 1};
		edges[1] = new int[]{0, 2};
		edges[2] = new int[]{2, 1};
		edges[3] = new int[]{2, 4};
		System.out.println(validTree(5, edges));
	}
}
