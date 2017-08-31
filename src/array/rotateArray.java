package array;

public class rotateArray {
    public static void main(String[] args) {
        int[] test = {1,2,3,4,5,6,7};
        rotate(test, 3);
        for(int i : test) {
            System.out.println(i);
        }
    }
    private static void rotate(int[] nums, int k) {
        if(nums == null) {
            return;
        }

        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    private static void reverse(int[] nums, int start, int end) {
        if(nums == null) {
            return;
        }
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
