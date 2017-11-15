package facebook3;

public class PrePermutation {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,4,7,3,1};
        prePermutation(nums);
        for(int num : nums) {
            System.out.println(num);
        }
    }

    public static void prePermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = 0, j = 0;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i+1] < nums[i]) {
                for (j = nums.length - 1; j >= i; j--) {
                    if (nums[i] > nums[j]) break;
                }
                swap(nums, i, j);
                reverse(nums, i + 1, nums.length - 1);
                return;
            }
        }

        reverse(nums, 0, nums.length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
