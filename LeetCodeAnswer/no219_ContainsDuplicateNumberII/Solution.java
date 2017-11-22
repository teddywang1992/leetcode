package no219_ContainsDuplicateNumberII;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // if (nums == null || nums.length == 0) return false;
        // HashMap<Integer, Integer> map = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        //     if (!map.containsKey(nums[i])) {
        //         map.put(nums[i], i);
        //     } else {
        //         if (i - map.get(nums[i]) <= k) {
        //             return true;
        //         } else {
        //             map.put(nums[i], i);
        //         }
        //     }
        // }
        // return false;
        
        k = (k > nums.length) ? nums.length : k;
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }
}