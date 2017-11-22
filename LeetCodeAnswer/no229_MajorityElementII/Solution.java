package no229_MajorityElementII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> majorityElement1(int[] nums) {
        //Voting algorithm, O(n), O(1)
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) return res;
        int num1 = nums[0], num2 = nums[0], count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            } else if (count1 == 0) {
                num1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                num2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == num1) {
                count1++;
            } else if (nums[i] == num2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) res.add(num1);
        if (count2 > nums.length / 3) res.add(num2);
        return res;
    }
    
    public List<Integer> majorityElement(int[] nums) {
        return helper(nums, 3);
    }
    
    public List<Integer> helper(int[] nums, int k) {
        List<Integer> ret = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (nums.length == 0) return ret;
        for (int n : nums) {
            if (map.containsKey(n)) map.put(n, map.get(n) + 1);
            else if (map.keySet().size() < k - 1) map.put(n, 1);
            else {
                    boolean flag = false;
                    for (Integer i : map.keySet()) {
                        if (map.get(i) == 0) {
                            map.remove(i);
                            map.put(n, 1);
                            flag = true;
                            break;
                        }
                    }
                    if (flag == false) {
                        for (Integer i : map.keySet()) {
                            map.put(i, map.get(i) - 1);
                        }
                    }
                 }
        }
        for (Integer i : map.keySet()) {
        	map.put(i, 0);
        }
        for (int n : nums) {
           if (map.containsKey(n)) map.put(n, map.get(n) + 1); 
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) > nums.length / k) ret.add(i);
        }
        return ret;
    }
}
