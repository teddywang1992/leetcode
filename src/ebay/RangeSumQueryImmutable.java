package ebay;

public class RangeSumQueryImmutable {
    int[] prefix;
    public RangeSumQueryImmutable(int[] nums) {
        prefix = new int[nums.length + 1];
        prefix[0] = 0;
        for (int i = 1; i < nums.length + 1; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return prefix[j + 1] - prefix[i];
    }
}
