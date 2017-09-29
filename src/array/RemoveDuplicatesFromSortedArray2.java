package array;

public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] nums) {
        int index = 0;

        for (int num : nums) {
            if (index < 2 || num > nums[index - 2]) {
                nums[index++] = num;
                // index++;
            }
        }

        return index;
    }
}
