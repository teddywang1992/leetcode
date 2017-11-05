package facebook1;

import java.util.Random;

public class RandomPickIndex {
    int[] nums;
    Random random;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    public int pick(int target) {
        int count = 0;
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && random.nextInt(++count) == 0) {
                index = i;
            }
        }

        return index;
    }
}
