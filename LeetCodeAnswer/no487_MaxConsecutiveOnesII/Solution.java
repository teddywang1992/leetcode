package no487_MaxConsecutiveOnesII;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 1, index = 0, pos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                res = Math.max(res, i - index + 1);
            } else {
                if (pos < 0) {
                    res = Math.max(res, i - index + 1);
                    pos = i;
                } else {
                    index = pos + 1;
                    pos = i;
                }
            }
        }
        return res;
    }
}
