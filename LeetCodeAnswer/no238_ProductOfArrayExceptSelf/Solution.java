package no238_ProductOfArrayExceptSelf;

public class Solution {
	public int[] productExceptSelf(int[] nums) {
		// long result = 1;
		// int[] ans = new int[nums.length];
		// int count = 0;
		// for (int num: nums) {
		// if (num == 0) {
		// count++;
		// continue;
		// }
		// result *= num;
		// }
		// if (count > 1) {
		// return ans;
		// }
		// if (count == 1) {
		// for (int i = 0; i < nums.length; i++) {
		// if (nums[i] == 0) {
		// ans[i] = (int)(result);
		// } else {
		// ans[i] = 0;
		// }
		// }
		// return ans;
		// }
		// for (int i = 0; i < nums.length; i++) {
		// ans[i] = (int)(result / nums[i]);
		// }
		// return ans;
		int[] res = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
			res[i] = 1;
		int left = 1, right = 1;
		for (int i = 0; i < nums.length; i++) {
			res[i] *= left;
			left *= nums[i];
			res[nums.length - 1 - i] *= right;
			right *= nums[nums.length - 1 - i];
		}
		return res;
	}
}