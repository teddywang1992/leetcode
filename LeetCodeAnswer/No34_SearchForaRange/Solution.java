package No34_SearchForaRange;

public class Solution {
	public int[] searchRange(int[] nums, int target) {
		int first = -1, last = -1;
		int[] result = new int[2];
		result[0] = result[1] = -1;
		if (nums == null || nums.length == 0)
			return result;
		int start = 0, end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] >= target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (nums[start] == target) {
			first = start;
		} else if (nums[end] == target) {
			first = end;
		} else {
			return result;
		}
		start = 0;
		end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] <= target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		if (nums[end] == target) {
			last = end;
		} else if (nums[start] == target) {
			last = start;
		} else {
			return result;
		}
		result[0] = first;
		result[1] = last;
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] result = solution.searchRange(new int[]{1,2,2,2,3}, 2);
		for (int i: result) {
			System.out.println(i);
		}
	}
}
