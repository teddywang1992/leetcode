package microsoft;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }

        return n * (n + 1) / 2 - sum;
    }
}
