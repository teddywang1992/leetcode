package dynamicProgramming;

/*
The idea is to use two arrays len[n] and cnt[n] to record the maximum length of Increasing Subsequence and the coresponding
number of these sequence which ends with nums[i], respectively. That is:

len[i]: the length of the Longest Increasing Subsequence which ends with nums[i].
cnt[i]: the number of the Longest Increasing Subsequence which ends with nums[i].

Then, the result is the sum of each cnt[i] while its corresponding len[i] is the maximum length.
*/

public class NumberOfLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        int result = 0;
        int maxLength = 0;
        int[] length = new int[nums.length];
        int[] count = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            count[i] = 1;
            length[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (length[i] == length[j] + 1) count[i] += count[j];
                    if (length[i] < length[j] + 1) {
                        count[i] = count[j];
                        length[i] = length[j] + 1;
                    }
                }
            }

            if (maxLength == length[i]) result += count[i];
            if (maxLength < length[i]) {
                maxLength = length[i];
                result = count[i];
            }
        }

        return result;
    }
}
