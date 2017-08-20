package binarySearch;

public class searchInSortedArray {
    public static void main(String[] args) {
        int[] test = {4,5,6,7,0,1,2};
        searchInSortedArray obj = new searchInSortedArray();
        System.out.println(obj.search(test, 6));
    }
    private int search(int[] nums, int target) {
        if(nums.length == 0 || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[start] < nums[mid]) {
                if(target >= nums[start] && target < nums[mid]) {
                    end = mid;
                }
                else {
                    start = mid;
                }
            }
            else {
                if(target > nums[mid] && target <= nums[end]) {
                    start = mid;
                }
                else {
                    end = mid;
                }
            }
        }
        if(target == nums[start]) {
            return start;
        }
        if(target == nums[end]) {
            return end;
        }
        return -1;
    }
}

