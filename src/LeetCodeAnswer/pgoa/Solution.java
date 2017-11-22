package LeetCodeAnswer.pgoa;

public class Solution {
	static String canReach(int x1, int y1, int x2, int y2) {
		if (helper(x1, y1, x2, y2)) {
			return "Yes";
		} else {
			return "No";
		}
	}
	
	static boolean helper(int x1, int y1, int x2, int y2) {
		// (x, y) -> (x + y, y) or (x, x + y)
		int tmp = x1 + y1;
		if (x2 < tmp && y2 < tmp) return false;
		if (x2 == tmp && y2 == y1) return true;
		if (y2 == tmp && x2 == x1) return true;
		return helper(x1 + y1, y1, x2, y2) || helper(x1, x1 + y1, x2, y2);
	}
	
	public static void main(String[] args) {
		System.out.println(helper(1, 2, 2, 1));
	}
}
