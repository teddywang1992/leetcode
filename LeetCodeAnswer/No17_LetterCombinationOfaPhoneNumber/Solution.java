package No17_LetterCombinationOfaPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits.isEmpty())
			return result;
		HashMap<Character, String> map = new HashMap<Character, String>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");

		StringBuilder sb = new StringBuilder();
		dfs(result, map, sb, 0, digits);
		return result;
	}

	private void dfs(List<String> result, HashMap<Character, String> map,
			StringBuilder sb, int pos, String digits) {
		if (pos == digits.length()) {
			result.add(sb.toString());
			return;
		}
		for (char c : map.get(digits.charAt(pos)).toCharArray()) {
			sb.append(c);
			dfs(result, map, sb, pos + 1, digits);
			sb.setLength(sb.length() - 1);
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.letterCombinations("22"));

	}

}
