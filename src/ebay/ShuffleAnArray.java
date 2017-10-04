package ebay;

import java.util.Random;

//shuffle an array

public class ShuffleAnArray {
    int[] nums;
    Random random;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null) return null;

        int[] shuffleNums = nums.clone();

        for (int i = 0; i < nums.length; i++) {
            int j = random.nextInt(i + 1);
            swap(shuffleNums, i, j);
        }

        return shuffleNums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}