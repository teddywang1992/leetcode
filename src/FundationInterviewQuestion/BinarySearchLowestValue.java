package FundationInterviewQuestion;

public class BinarySearchLowestValue {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int start = 0, end = nums.length - 1;
        int target = nums[end];

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}
