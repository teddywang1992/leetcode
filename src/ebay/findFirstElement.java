package ebay;

public class findFirstElement {
    public static void main(String[] args) {
        int[] nums = {1,2,2,2,2,3,3,4,5};
        System.out.println(findFirst(nums, 3));
    }

    private static int findFirst(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < target) start = mid;
            else end = mid;
        }

        if (nums[start] == target) return start;
        else return end;
    }
}
