package facebook3;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,2,13};
        moveZero(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    private static void moveZero(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            while (start < nums.length && nums[start] != 0) start++;
            while (end >= 0 && nums[end] == 0) end--;
            if (start < end) {
                swap(nums, start, end);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                nums[left++] = nums[right];
            }
        }
        while (left < nums.length) {
            nums[left++] = 0;
        }
    }
}
