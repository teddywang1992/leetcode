package ebay;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        if (nums == null || nums.length == 0) return 0;

        for (int num : nums) {
            sum += num;
        }

        return n * (n + 1) / 2 - sum;
    }
}
