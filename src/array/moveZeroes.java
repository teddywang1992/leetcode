package array;

public class moveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 2, 3};
        moveZeroes(nums);
        for(int i : nums) {
            System.out.println(i);
        }
    }
    private static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int left = 0;
        int right = 0;

        while(right < nums.length) {
            if(nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }
    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
