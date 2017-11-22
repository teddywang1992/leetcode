package LeetCodeAnswer.No96_UniqueBinarySearchTrees;

public class Solution {
	public int numTrees(int n) {
		int[] result = new int[n + 1];
		result[0] = result[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				result[i] += result[i - j] * result[j - 1];
			}
		}
		return result[n];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.numTrees(10));
	}

}
