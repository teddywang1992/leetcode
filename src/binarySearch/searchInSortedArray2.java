package binarySearch;

public class searchInSortedArray2 {
    public static void main(String[] args) {
        int[] test = {4,5,6,7,0,1,2};
        searchInSortedArray2 obj = new searchInSortedArray2();
        System.out.println(obj.search(test, 6));
    }
    private boolean search(int[] nums, int target) {
        if (nums.length == 0 || nums == null) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]){
                return true;
            }
        }
        return false;
    }
}
