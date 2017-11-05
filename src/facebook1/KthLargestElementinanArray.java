package facebook1;

public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        int pos = nums.length - k;
        quickSelect(nums, 0, nums.length - 1, pos);
        return nums[pos];
    }

    private void quickSelect(int[] nums, int i, int j, int k){
        if(i >= j){
            return;
        }
        int start = i, end = j, x = nums[start + (end - start) / 2];
        while(start <= end){
            while(nums[start] < x){ // < 而不是 <=, mid的存在可确保不会indexOutOfBound
                start++;
            }
            while(nums[end] > x){
                end--;
            }
            if(start <= end){
                int temp = nums[start];
                nums[start++] = nums[end];
                nums[end--] = temp;
            }
        }
        if(start - 1 >= k){ // 0 ~ start-1 都是 <= x的数，start ~ end 都是 >= x的数
            quickSelect(nums, i, start - 1, k);
        }
        else{
            quickSelect(nums, start, j, k);
        }
    }
}
