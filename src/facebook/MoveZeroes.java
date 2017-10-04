package facebook;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    private static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int start = 0;
        int end = 0;

        while (end < nums.length) {
            if (nums[end] != 0) {
                swap(nums, start, end);
                start++;
            }
            end++;
        }
    }

    private static void swap(int[] nums, int start, int end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
    }
}
