package binarySearch;

public class searchForARange {
    public static void main(String[] args) {
        int[] test = {5,7,7,8,8,10};
        searchForARange obj = new searchForARange();
        int[] result = obj.searchRange(test, 8);
        for(int i: result) {
            System.out.println("range:" + i);
        }
    }
    private int[] searchRange(int[] nums, int target) {
        int[] result = {0, 0};
        if (nums.length == 0 || nums == null) {
            return result;
        }
        int start = 0;
        int end = nums.length - 1;
        //find left
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            }else if(nums[mid] < target) {
                start = mid;
            }else {
                end = mid;
            }
        }
        if (nums[start] == target) {
            result[0] = start;
        }else if(nums[end] == target){
            result[0] = end;
        }else {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        //find right
        start = 0;
        end = nums.length - 1;
        while (start + 1 < end) {

            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            }else if (nums[mid] < target) {
                start = mid;
            }else {
                end = mid;
            }

        }
        if (nums[end] == target) {
            result[1] = end;
        }else if (nums[start] == target){
            result[1] = start;
        }else {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        return result;
    }
}

