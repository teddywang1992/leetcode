package facebook1;

public class TotalHammingDistance {
    public int totalHammingDistance(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            int count = 0;
            for (int num : nums) {
                count += (num >> i) & 1;
            }
            result += count * (nums.length - count);
        }

        return result;
    }
}
