package FacebookInterview;

public class LongestIncreasingSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6};
        System.out.println(increasingSubarray2(nums));
    }

    private static int increasingSubarray1(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0, end = 0;
        int max = 0;
        while (end < nums.length - 1) {
            if (nums[end + 1] > nums[end]) {
                end++;
            }
            else {
                max = Math.max(max, end - start);
                end++;
                start = end;
            }
        }
        max = Math.max(max, end - start);
        return max + 1;
    }

    private static int increasingSubarray2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int res = 1, cur = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) cur = 1;
            else if (nums[i] > nums[i - 1]) {
                cur++;
                res = Math.max(res, cur);
            }
            else {
                cur = 0;
            }
        }
        return res;
    }
}
