package array;

public class maximumSubarray {
    public static void main(String[] args) {
        int[] test = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(test));
    }

    private static int maxSubArray(int[] nums) {
        if(nums == null) {
            return Integer.MIN_VALUE;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }

        return max;
    }
}
