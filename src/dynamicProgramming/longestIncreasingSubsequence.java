package dynamicProgramming;

public class longestIncreasingSubsequence {
    public static void main(String[] args) {
        longestIncreasingSubsequence obj = new longestIncreasingSubsequence();
        int [] test = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(" longest : " + obj.lengthOfLIS(test));
    }
    private int lengthOfLIS(int[] nums) {
        if(nums.length == 0 || nums == null) {
            return 0;
        }
        //state
        int n = nums.length;
        int[] f = new int[n];

        //init
        for(int i = 0; i < n; i++) {
            f[i] = 1;
        }

        //top down
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    f[i] = f[i] > f[j] + 1 ? f[i] : f[j] + 1;
                }
            }
        }

        //answer
        int max = f[0];
        for(int i = 0; i < n; i++) {
            max = Math.max(max, f[i]);
        }
        return max;
    }
}
