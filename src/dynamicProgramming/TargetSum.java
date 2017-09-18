package dynamicProgramming;

public class TargetSum {
    public int result = 0;

    public int findTargetSumWays(int[] nums, int S) {

        helper(nums, 0, S);

        return result;
    }

    private void helper(int[] nums, int start, int S) {

        if (start == nums.length) {
            if (S == 0) {
                result++;
            }
            return;
        }

        helper(nums, start + 1, S + nums[start]);
        helper(nums, start + 1, S - nums[start]);
    }
}
