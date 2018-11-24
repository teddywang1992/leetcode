package Linkedin;

import java.util.*;

public class twoSum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(nums.length);
    }

    private int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.size() != 0 && map.containsKey(target - nums[i])) {
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
