package array;

public class sortColors {
    private  void sortColors(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }

        int left = 0;
        int i = 0;
        int right = nums.length - 1;

        while(i <= right) {
            if(nums[i] == 0) {
                swap(nums, i, left);
                i++;
                left++;
            } else if(nums[i] == 1) {
                i++;
            } else {
                swap(nums, i, right);
                right--;
            }
        }
    }
    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
