package LeetCodeAnswer.no169_MajorityElement;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	// Sorting
	public int majorityElement1(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	// Hashtable
	public int majorityElement2(int[] nums) {
		HashMap<Integer, Integer> myMap = new HashMap<Integer, Integer>();
		int ret = 0;
		for (int num : nums) {
			if (!myMap.containsKey(num))
				myMap.put(num, 1);
			else
				myMap.put(num, myMap.get(num) + 1);
			if (myMap.get(num) > nums.length / 2) {
				ret = num;
				break;
			}
		}
		return ret;
	}

	// Moore voting algorithm
	public int majorityElement(int[] nums) {
		int count = 0, ret = 0;
		for (int num : nums) {
			if (count == 0)
				ret = num;
			if (num != ret)
				count--;
			else
				count++;
		}
		return ret;
	}
}