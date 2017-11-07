package facebook1;

public class TargetSum1 {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,3,4,5};
        System.out.println(helper(nums, 5));
    }
    public static int findTargetSumWays(int[] nums, int S) {
        if (nums == null || nums.length == 0 ) return 0;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum < S || (sum + S) % 2 != 0) return 0; // [1000]   -1000

        return helper(nums, (sum + S) / 2);
    }

    private static int helper(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= 0; i--) {
                if (i >= num) {
                    dp[i] += dp[i - num];
                }
            }
        }

        return dp[target];
    }
}
