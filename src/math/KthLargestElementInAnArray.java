package math;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,5,4};
        System.out.println(findKthLargest(nums, 2));
    }
    private static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (k <= 0) {
            return 0;
        }

        return helper(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    private static int helper(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }

        int position = patition(nums, left, right);

        if (position + 1 == k) {
            return nums[position];
        } else if (position + 1 < k) {
            return helper(nums, position + 1, right, k);
        } else {
            return helper(nums, left, position - 1, k);
        }
    }

    private static int patition(int[] nums, int left, int right) {
        int pivot = nums[left];

        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }

        nums[left] = pivot;

        return left;
    }
}

