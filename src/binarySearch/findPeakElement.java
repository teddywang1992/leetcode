package binarySearch;

public class findPeakElement {
    public static void main (String[] args) {
        int[] test = {1,2,3,1};
        findPeakElement obj = new findPeakElement();
        System.out.println(obj.findPeakElement(test));
    }
    private int findPeakElement(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid - 1]) {
                end = mid;
            }else if (nums[mid] < nums[mid + 1]){
                start = mid;
            }else {
                end = mid;
            }
        }
        if (nums[start] > nums[end]) {
            return start;
        }else {
            return end;
        }
    }
}
