package LeetCodeAnswer.no398_RandomPickIndex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Solution {
	// Random rand;
	// HashMap<Integer, List<Integer>> map = new HashMap<Integer,
	// List<Integer>>();
	// public Solution(int[] nums) {
	// rand = new Random();
	// for (int i = 0; i < nums.length; i++) {
	// if (map.containsKey(nums[i])) {
	// map.get(nums[i]).add(i);
	// } else {
	// List<Integer> list = new ArrayList<Integer>();
	// list.add(i);
	// map.put(nums[i], list);
	// }
	// }
	// }
	//
	// public int pick(int target) {
	// List<Integer> list = map.get(target);
	// return list.get(rand.nextInt(list.size()));
	// }
	int[] nums;
	Random rand = new Random();

	public Solution(int[] nums) {
		this.nums = nums;
	}

	public int pick(int target) {
		int res = -1, count = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != target)
				continue;
			if (rand.nextInt(++count) == 0)
				res = i;
		}
		return res;
	}
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(nums); int param_1 = obj.pick(target);
 */
