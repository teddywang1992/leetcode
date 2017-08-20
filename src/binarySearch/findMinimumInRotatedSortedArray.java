package binarySearch;

public class findMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] test;
        test = new int[]{1,2,3};
        findMinimumInRotatedSortedArray obj = new findMinimumInRotatedSortedArray();
        System.out.println(obj.findMin(test));

    }
    private int findMin(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int target = nums[end];
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
}
