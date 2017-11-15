package facebook3;

public class NextPermutation {
    public static void main(String[] args) {
        String s = "1234567";
        StringBuilder sb = new StringBuilder(s);
    }
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = 0, j = 0;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i+1] > nums[i]) {
                for (j = nums.length - 1; j >= i; j--) {
                    if (nums[j] > nums[i]) break;
                }
                swap(nums, i, j);
                reverse(nums, i + 1, nums.length - 1);
                return;
            }
        }

        reverse(nums, 0, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
