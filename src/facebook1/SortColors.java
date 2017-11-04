package facebook1;

public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, left, i);
                i++;
                left++;
            }
            else if (nums[i] == 1) {
                i++;
            }
            else {
                swap(nums, i, right);
                right--;
            }
        }
    }

    private void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
