package ebay;

public class nextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3 ,4, 5, 6};
        reverse(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int target = nums[nums.length - 1];
        int i = 0;
        int j = 0;

        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i + 1] > nums[i]) {
                for (j = nums.length - 1; j >= i; j--) {
                    if (nums[i] < nums[j]) break;
                }
                swap(nums, i, j);
                reverse(nums, i + 1, nums.length - 1);
                return;
            }
        }
        reverse(nums, 0, nums.length - 1);
    }

    private static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    private static void reverse(int[] nums, int left, int right) {
        if (left > right) return;
        for (int i = left; i <=(left + right) / 2; i++) {
            swap(nums, i, left + right - i);
        }
    }
}
