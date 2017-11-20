package facebook3;

public class NumberofLongestIncreasingSubsequence {
    public int findNumberOfLIS(int[] nums) {
        int result = 0;
        if (nums == null || nums.length == 0) return result;
        int maxLength = 0;
        int[] count = new int[nums.length];
        int[] length = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            count[i] = 1;
            length[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (length[j] + 1 == length[i]) count[i] += count[j];
                    if (length[j] + 1 > length[i]) {
                        count[i] = count[j];
                        length[i] = length[j] + 1;
                    }
                }
            }
            if (maxLength == length[i]) {
                result += count[i];
            }

            if (maxLength < length[i]) {
                result = count[i];
                maxLength = length[i];
            }
        }

        return result;
    }
}
