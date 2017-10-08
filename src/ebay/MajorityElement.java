package ebay;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        int count = 1;
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                count = 1;
                max = nums[i];
            } else if (max == nums[i]) {
                count++;
            } else if (max != nums[i]) {
                count--;
            }
        }

        return max;
    }
}
