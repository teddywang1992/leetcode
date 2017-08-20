package binarySearch;

public class searchInsertPosition {
    public static void main(String[] args) {
        int[] test = {1,3,5,6};
        searchInsertPosition obj = new searchInsertPosition();
        System.out.println(obj.searchInsert(test, 2));
    }
    private int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (nums[start] >= target) {
            return start;
        }
        if (nums[end] >= target) {
            return end;
        }
        return nums.length;
    }
}
