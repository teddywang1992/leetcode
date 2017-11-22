package LeetCodeAnswer.no265_PaintHouseII;

public class Solution {
    public int minCostII(int[][] costs) {
    	if (costs.length == 0 || costs[0].length == 0) {
    		return 0;
    	}
        int n = costs.length, k = costs[0].length;
        
        //dp[i][j] indicate the optimal cost for the house i if it is painted with color j.
        int[][] dp = new int[n][k];
        for (int j = 0; j < k; j++) 
        	dp[0][j] = costs[0][j];
        
        for (int i = 1; i < n; i++) {
        	for (int j = 0; j < k; j++) {
        		dp[i][j] = minCost(dp[i-1], j) + costs[i][j];
        	}
        }
        return minCost(dp[n-1], -1);
    }
    
    //find the minimum cost if the current house is painted with different color except j.
    //if j == -1, then find minimum cost for the current house comparing different color.
    private int minCost(int[] dp, int j) {
    	int min = Integer.MAX_VALUE;
    	int i = 0; 
    	while (i < dp.length) {
    		if (j != -1 && i == j) 
    			;
    		else
    			min = Math.min(min, dp[i]);
    		i++;
    	}
    	return min;
    }
}