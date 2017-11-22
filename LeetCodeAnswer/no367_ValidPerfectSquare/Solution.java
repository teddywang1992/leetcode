package no367_ValidPerfectSquare;

public class Solution {
	public boolean isPerfectSquare(int num) {
		if (num == 0 || num == 1)
			return true;
		if (num < 0)
			return false;
		long start = 1, end = num;
		while (start + 1 < end) {
			long mid = start + (end - start) / 2;
			if (mid * mid > num) {
				end = mid;
			} else if (mid * mid < num) {
				start = mid;
			} else {
				return true;
			}
		}
		if ((int) (start * start) == num)
			return true;
		if ((int) (end * end) == num)
			return true;
		return false;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.isPerfectSquare(16));
	}

}
