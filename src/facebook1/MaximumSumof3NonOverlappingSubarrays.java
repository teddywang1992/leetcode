package facebook1;

public class MaximumSumof3NonOverlappingSubarrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[]{};
        int n = nums.length;
        int[] leftDP = new int[n];
        int[] rightDP = new int[n];
        int[] sums = new int[n + 1];
        int[] result = new int[3];
        for (int i = 0; i < n; i++) {
            sums[i+1] = sums[i] + nums[i];
        }

        for (int i = k, tot = sums[k] - sums[0]; i < n; i++) {
            if (sums[i+1] - sums[i+1-k] > tot) {
                leftDP[i] = i + 1 - k;
                tot = sums[i+1] - sums[i+1-k];
            }
            else {
                leftDP[i] = leftDP[i-1];
            }
        }
        rightDP[n-k] = n-k;
        for (int i = n - k - 1, tot = sums[n] - sums[n-k]; i >= 0; i--) {
            if (sums[i + k] - sums[i] >= tot) {
                tot = sums[i+k] - sums[i];
                rightDP[i] = i;
            }
            else {
                rightDP[i] = rightDP[i+1];
            }
        }

        int maxSum = 0;
        for (int i = k; i <= n - 2*k; i++) {
            int left = leftDP[i-1];
            int right = rightDP[i+k];
            int tot = (sums[i+k] - sums[i]) + (sums[left+k] - sums[left]) + (sums[right+k] - sums[right]);
            if (tot > maxSum) {
                maxSum = tot;
                result[0] = left; result[1] = i; result[2] = right;
            }
        }

        return result;
    }
}
