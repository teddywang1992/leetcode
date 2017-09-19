package dynamicProgramming;

import java.util.Arrays;
/*
我们定义一个一维的dp数组，其中dp[i]表示数字i是否是原数组的任意个子集合之和，那么我们我们最后只需要返回dp[target]就行了。
我们初始化dp[0]为true，由于题目中限制了所有数字为正数，那么我们就不用担心会出现和为0或者负数的情况。那么关键问题就是要找出递归公式了，
我们需要遍历原数组中的数字，对于遍历到的每个数字nums[i]，我们需要更新我们的dp数组，要更新[nums[i], target]之间的值，
那么对于这个区间中的任意一个数字j，如果dp[j - nums[i]]为true的话，那么dp[j]就一定为true，于是地推公式如下：

dp[j] = dp[j] || dp[j - nums[i]]         (nums[i] <= j <= target)

有了递推公式，那么我们就可以写出代码如下：
*/

public class PartitionEqualSubsetSum {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 == 1) return false;

        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        Arrays.fill(dp, false);

        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }

        return dp[target];
    }
}
